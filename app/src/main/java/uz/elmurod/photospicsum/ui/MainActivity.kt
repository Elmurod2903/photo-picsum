package uz.elmurod.photospicsum.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.elmurod.photospicsum.adapter.PhotoAdapter
import uz.elmurod.photospicsum.databinding.ActivityMainBinding
import uz.elmurod.photospicsum.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: PhotoAdapter

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerview()
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        initViewModel()
    }


    private fun initRecyclerview() {
        adapter = PhotoAdapter()
        binding.listImages.adapter = adapter

    }

    private fun initViewModel() {

        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null) {
                adapter.setItemList(it)
                adapter.notifyDataSetChanged()
                viewModel.insertAllPhotosDB(it)
            } else {
                Toast.makeText(
                    this,
                    "Error in getting list or Not network to internet",
                    Toast.LENGTH_SHORT
                )
                    .show()
                viewModel.getAllPhotosDB()
            }
        })
        viewModel.makeApiCall()
    }






}