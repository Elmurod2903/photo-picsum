package uz.elmurod.photospicsum.app

import android.app.Application
import uz.elmurod.photospicsum.db.PhotosRoomDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        PhotosRoomDatabase.initDatabase(this)
    }
}