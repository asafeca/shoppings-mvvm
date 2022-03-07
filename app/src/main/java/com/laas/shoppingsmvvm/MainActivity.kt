package com.laas.shoppingsmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.laas.shoppingsmvvm.data.adapter.listeners.ProductInfoListener
import com.laas.shoppingsmvvm.databinding.ActivityMainBinding
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

class MainActivity : AppCompatActivity(), ProductInfoListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onProductClick(product: ProductInfoModel) {

    }

}