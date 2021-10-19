package uz.elmurod.photospicsum.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.elmurod.photospicsum.data.PhotoModel
import uz.elmurod.photospicsum.db.PhotosRoomDatabase
import uz.elmurod.photospicsum.retrofit.RestApi

class MainActivityViewModel : ViewModel() {

     var liveDataList  = MutableLiveData<List<PhotoModel>>()

    fun getLiveDataObserver(): MutableLiveData<List<PhotoModel>> {
        return liveDataList
    }

    fun makeApiCall() {
        val restApi = RestApi.getRetrofit()
        val call = restApi!!.getImageList()
        call.enqueue(object : Callback<List<PhotoModel>> {
            override fun onResponse(
                call: Call<List<PhotoModel>>,
                response: Response<List<PhotoModel>>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }


    fun insertAllPhotosDB(items: List<PhotoModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            PhotosRoomDatabase.getDatabase().photosDao().deleteAll()
            PhotosRoomDatabase.getDatabase().photosDao().insertAll(items)
        }

    }

    fun getAllPhotosDB() {
        CoroutineScope(Dispatchers.Main).launch {
            liveDataList.value = withContext(Dispatchers.IO) {
                PhotosRoomDatabase.getDatabase().photosDao().getAllPhotos()
            }
        }
    }
}