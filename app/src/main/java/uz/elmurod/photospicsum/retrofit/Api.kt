package uz.elmurod.photospicsum.retrofit

import retrofit2.Call
import retrofit2.http.GET
import uz.elmurod.photospicsum.data.PhotoModel

interface Api {

    @GET("v2/list")
    fun getImageList(): Call<List<PhotoModel>>
}