package uz.elmurod.photospicsum.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.elmurod.photospicsum.db.PhotoDao
import uz.elmurod.photospicsum.db.PhotosRoomDatabase
import uz.elmurod.photospicsum.retrofit.Api
import uz.elmurod.photospicsum.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getPhotoDao(database: PhotosRoomDatabase): PhotoDao {
        return database.photosDao()
    }

    @Provides
    @Singleton
    fun getAppDatabase(context: Context):PhotosRoomDatabase {
        return PhotosRoomDatabase.initDatabase(context)
    }

    @Provides
    @Singleton
    fun getRestApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}