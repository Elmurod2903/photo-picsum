package uz.elmurod.photospicsum.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.elmurod.photospicsum.data.PhotoModel

@Database(entities = [PhotoModel::class], version = 1,exportSchema = false)
abstract class PhotosRoomDatabase : RoomDatabase() {

    abstract fun photosDao(): PhotoDao

    companion object {
        private var instance: PhotosRoomDatabase? = null

        fun initDatabase(context: Context) {
            if (instance == null) {
                synchronized(PhotosRoomDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PhotosRoomDatabase::class.java,
                        "photos.db"
                    ).build()
                }
            }

        }

        fun getDatabase(): PhotosRoomDatabase {
            return instance!!
        }
    }
}