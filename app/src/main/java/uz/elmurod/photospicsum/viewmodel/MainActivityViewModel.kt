package uz.elmurod.photospicsum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.elmurod.photospicsum.data.PhotoModel
import uz.elmurod.photospicsum.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: PhotoRepository) :
    ViewModel() {
//    var liveDataList = MutableLiveData<List<PhotoModel>>()


    fun getAllList(): LiveData<List<PhotoModel>> {
        return repository.getAllPhotos()
    }

    fun makeApi() {
        repository.makeApi()
    }


}