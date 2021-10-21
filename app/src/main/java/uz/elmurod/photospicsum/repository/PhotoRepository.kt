package uz.elmurod.photospicsum.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.elmurod.photospicsum.data.PhotoModel
import uz.elmurod.photospicsum.db.PhotoDao
import uz.elmurod.photospicsum.retrofit.Api
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val api: Api,
    private val photoDao: PhotoDao,
    private val items: List<PhotoModel>
) {
    private var job: Job? = null

    fun getAllPhotos(): LiveData<List<PhotoModel>> {
        return photoDao.getAllPhotos()
    }

    private fun insertPhotos(items: List<PhotoModel>) {
        photoDao.insertAll(items)
    }

    fun makeApi() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val res = api.getImageList()
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {
                    photoDao.deleteAll()
                    res.body()?.forEach { _ ->
                        insertPhotos(items)
                    }
                }
            }
        }

    }
}