package com.laas.shoppingsmvvm.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.laas.shoppingsmvvm.databinding.ActivityDetailsBinding

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
        binding.productName.text = intent.getStringExtra("productName")

        binding.imgClose.setOnClickListener {
            finish()
        }

    }
}