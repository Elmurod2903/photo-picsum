package uz.elmurod.photospicsum.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.elmurod.photospicsum.data.PhotoModel

@Database(entities = [PhotoModel::class], version = 1, exportSchema = false)
abstract class PhotosRoomDatabase : RoomDatabase() {

    abstract fun photosDao(): PhotoDao

    companion object {
        private var instance: PhotosRoomDatabase? = null

        fun initDatabase(context: Context): PhotosRoomDatabase {
            if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PhotosRoomDatabase::class.java,
                        "photo.db"
                    ).allowMainThreadQueries().build()

            }
            return instance!!
        }

    }
}