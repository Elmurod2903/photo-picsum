package uz.elmurod.photospicsum.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "photos")
data class PhotoModel(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "download_url")val download_url: String
):Serializable