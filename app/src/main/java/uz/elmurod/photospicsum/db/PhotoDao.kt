package uz.elmurod.photospicsum.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.elmurod.photospicsum.data.PhotoModel

@Dao
interface PhotoDao {
    @Query("DELETE from photos")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<PhotoModel>)

    @Query("select * from photos")
    fun getAllPhotos(): List<PhotoModel>
}