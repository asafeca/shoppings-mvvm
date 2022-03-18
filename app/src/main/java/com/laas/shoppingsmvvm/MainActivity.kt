package com.laas.shoppingsmvvm

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.data.adapter.ProductInfoAdapter
import com.laas.shoppingsmvvm.data.adapter.listeners.ProductInfoListener
import com.laas.shoppingsmvvm.data.util.GsonParser
import com.laas.shoppingsmvvm.databinding.ActivityMainBinding
import com.laas.shoppingsmvvm.di.ShoppingsApp
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.presentation.AppLoginActivity
import com.laas.shoppingsmvvm.presentation.DetailsActivity
import com.laas.shoppingsmvvm.presentation.viewmodel.ProductInfoViewModel
import com.laas.shoppingsmvvm.presentation.viewmodel.ProductInfoViewModelFactory
import dmax.dialog.SpotsDialog

class MainActivity : AppCompatActivity(), ProductInfoListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var alertDialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        prepareFields()
        loadData()
    }


    override fun onProductClick(product: ProductInfoModel) {
        val json = GsonParser(Gson()).toJson(product, ProductInfoModel::class.java)
        startActivity(
            Intent(this@MainActivity, DetailsActivity::class.java).putExtra(
                "product",
                json
            )
        )
    }

    private fun prepareFields() {

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        alertDialog = SpotsDialog.Builder().setContext(this).build()

        binding.imgSearch.setOnClickListener {
            loadData()
        }
        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this@MainActivity, AppLoginActivity::class.java))
            finish()
        }
    }

    private fun loadData() {
        alertDialog.setMessage(getString(R.string.waiting_message))
        alertDialog.show()
        productViewModel.onGet { result ->
            when (result) {
                is Resource.Success -> {

                    if (result.data!!.isNotEmpty()) {
                        // AVOIDING Only the original thread that created a view hierarchy can touch its views. Error

                        this@MainActivity.runOnUiThread(Runnable {

                            binding.recyclerView.adapter =
                                ProductInfoAdapter(result.data, this@MainActivity)
                            binding.recyclerView.setHasFixedSize(true)
                        })
                        alertDialog.dismiss()


                    } else {
                        alertDialog.dismiss()
                    }
                }
                is Resource.Error -> {

                    alertDialog.dismiss()

                }
                is Resource.Loading -> {

                    alertDialog.dismiss()
                }
            }

        }
    }


    private val productViewModel: ProductInfoViewModel by viewModels {
        ProductInfoViewModelFactory((applicationContext as ShoppingsApp).getProductInfo)
    }
}