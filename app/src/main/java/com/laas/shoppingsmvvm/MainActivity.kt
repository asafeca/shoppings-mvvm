package com.laas.shoppingsmvvm

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.data.adapter.ProductInfoAdapter
import com.laas.shoppingsmvvm.data.adapter.listeners.ProductInfoListener
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
    private lateinit var BTN_LOGOUT: Button
    lateinit var recyclerview: RecyclerView
    lateinit var alertDialog: AlertDialog
    var count: Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareFields()
    }


    override fun onProductClick(product: ProductInfoModel) {
        var intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra("productName", product.productName)

        startActivity(intent)

    }

    private fun prepareFields() {

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        alertDialog = SpotsDialog.Builder().setContext(this).build()
        recyclerview = findViewById(R.id.recycler_view)
        alertDialog.setMessage(R.string.loading.toString())

        BTN_LOGOUT = findViewById(R.id.btn_logout)
        BTN_LOGOUT.setOnClickListener {
            var intent = Intent(this@MainActivity, AppLoginActivity::class.java)
            startActivity(intent)
            finish()
        }



        productViewModel.onGet { result ->
            when (result) {
                is Resource.Success -> {

                    recyclerview.adapter = null

                    if (result.data!!.isNotEmpty()) {
                        alertDialog.cancel()

                        // AVOIDING Only the original thread that created a view hierarchy can touch its views. Error

                        this@MainActivity.runOnUiThread(Runnable {
                            recyclerview.adapter =
                                ProductInfoAdapter(result.data, this@MainActivity)
                            recyclerview.setHasFixedSize(true)
                        })


                    } else {
                        alertDialog.cancel()


                    }
                }
                is Resource.Error -> {
                    alertDialog.cancel()

                }
                is Resource.Loading -> {
                    alertDialog.show()
                }
            }

        }


    }


    private val productViewModel: ProductInfoViewModel by viewModels {
        ProductInfoViewModelFactory((applicationContext as ShoppingsApp).getProductInfo)
    }
}