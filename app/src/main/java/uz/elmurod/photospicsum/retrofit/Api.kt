package uz.elmurod.photospicsum.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import uz.elmurod.photospicsum.data.PhotoModel

interface Api {

    @GET("v2/list")
    suspend fun getImageList(): Response<List<PhotoModel>>
}