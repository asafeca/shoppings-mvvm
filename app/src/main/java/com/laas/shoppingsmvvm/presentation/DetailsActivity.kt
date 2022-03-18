package com.laas.shoppingsmvvm.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.laas.shoppingsmvvm.R
import com.laas.shoppingsmvvm.data.util.GsonParser
import com.laas.shoppingsmvvm.databinding.ActivityDetailsBinding
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareFields()

    }

    private fun prepareFields() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        var intent: Intent = getIntent()
        val product: ProductInfoModel = intent.getStringExtra("product")
            ?.let { GsonParser(Gson()).fromJson(it, ProductInfoModel::class.java) }!!

        binding.productName.text = product.productName
        binding.connectionType.text = product.connectionType
        binding.compatibility.text = product.compatibility
        binding.powerSupplyType.text = product.powerSupplySource
        binding.batteryLifeTime.text =
            product.batteryLifeTime.toString()+" "+getString(R.string.hours)
        binding.captureType.text = product.capture

        binding.imgClose.setOnClickListener {
            finish()
        }


    }
}