package uz.elmurod.photospicsum.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import uz.elmurod.photospicsum.data.PhotoModel
import uz.elmurod.photospicsum.databinding.ActivityDetailBinding
import uz.elmurod.photospicsum.util.Constants

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private var itemPhoto: PhotoModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemPhoto = intent.getSerializableExtra(Constants.DATA) as PhotoModel

        Glide.with(this).load("${Constants.IMAGE_URL + itemPhoto!!.id}/1080/560")
            .into(binding.imageItem)

    }
}