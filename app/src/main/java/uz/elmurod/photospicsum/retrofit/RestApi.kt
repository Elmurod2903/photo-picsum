package uz.elmurod.photospicsum.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.elmurod.photospicsum.util.Constants

object RestApi {
    private var api: Api? = null
    fun getRetrofit(): Api? {
        val retrofit: Retrofit?
        if (api == null) {

            retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            api = retrofit.create(Api::class.java)
        }
        return api
    }
}