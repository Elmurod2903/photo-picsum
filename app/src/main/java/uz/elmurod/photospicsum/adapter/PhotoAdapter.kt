package uz.elmurod.photospicsum.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.elmurod.photospicsum.ui.DetailActivity
import uz.elmurod.photospicsum.R
import uz.elmurod.photospicsum.data.PhotoModel
import uz.elmurod.photospicsum.databinding.ItemPhotoBinding
import uz.elmurod.photospicsum.util.Constants

class PhotoAdapter() :
    RecyclerView.Adapter<PhotoAdapter.PhotoVH>() {

    private var itemListPhoto: List<PhotoModel>? = null


    fun setItemList(itemList: List<PhotoModel>) {
        this.itemListPhoto = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoVH {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoVH(vh)
    }

    override fun onBindViewHolder(holder: PhotoVH, position: Int) {
        holder.bindPhoto(itemListPhoto?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if (itemListPhoto == null) 0
        else itemListPhoto?.size!!
    }

    inner class PhotoVH(private val view: View) :
        RecyclerView.ViewHolder(view) {
        lateinit var lastSelectedPhoto: PhotoModel

        private val binding = ItemPhotoBinding.bind(view)

        fun bindPhoto(item: PhotoModel) {
            this.lastSelectedPhoto = item
            view.setOnClickListener {
                val intent = Intent(it.context, DetailActivity::class.java)
                intent.putExtra(Constants.DATA, item)
                it.context.startActivity(intent)
            }

            Glide.with(binding.itemImage).load("${Constants.IMAGE_URL + item.id}/1080/560")
                .into(binding.itemImage)
        }
    }

}