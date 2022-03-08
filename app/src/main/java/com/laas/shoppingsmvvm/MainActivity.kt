package com.laas.shoppingsmvvm

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.data.adapter.ProductInfoAdapter
import com.laas.shoppingsmvvm.data.adapter.listeners.ProductInfoListener
import com.laas.shoppingsmvvm.databinding.ActivityMainBinding
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.presentation.AppLoginActivity
import com.laas.shoppingsmvvm.presentation.viewmodel.ProductInfoViewModel
import dmax.dialog.SpotsDialog
import java.lang.Error

class MainActivity : AppCompatActivity(), ProductInfoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var BTN_LOGOUT: Button
    lateinit var recyclerview: RecyclerView
    lateinit var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareFields()

    }

    override fun onProductClick(product: ProductInfoModel) {

    }

    private fun prepareFields() {



        alertDialog = SpotsDialog.Builder().setContext(this).build()
        recyclerview = findViewById(R.id.recycler_view)
        alertDialog.setMessage(R.string.loading.toString())


        BTN_LOGOUT = findViewById(R.id.btn_logout)
        BTN_LOGOUT.setOnClickListener {
            var intent = Intent(this, AppLoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*

        productViewModel.onGet { result ->
            when (result) {
                is Resource.Success -> {

                    if (result.data!!.isNotEmpty()) {
                        alertDialog.cancel()
                        recyclerview.adapter =
                            ProductInfoAdapter(result.data, this)

                    } else {
                        alertDialog.cancel()

                        Toast.makeText(this, R.string.empty_list_error, Toast.LENGTH_LONG).show()

                    }
                }
                is Resource.Error -> {
                    alertDialog.cancel()
                    Toast.makeText(this, result.message, Toast.LENGTH_LONG).show()
                }
                is Resource.Loading -> {
                    alertDialog.show()
                }
            }

        }

        */


    }


    private val productViewModel: ProductInfoViewModel by viewModels()
}