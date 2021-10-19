package uz.elmurod.photospicsum.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "photos")
data class PhotoModel(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val id: String,
    val author: String,
    val download_url: String
):Serializable