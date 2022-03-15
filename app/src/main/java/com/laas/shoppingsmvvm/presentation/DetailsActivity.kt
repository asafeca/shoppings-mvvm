package com.laas.shoppingsmvvm.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.laas.shoppingsmvvm.R

class DetailsActivity : AppCompatActivity() {

    private lateinit var imgClose: ImageView
    private lateinit var txtProductName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        prepareFields()

    }

    private fun prepareFields() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        txtProductName = findViewById(R.id.product_name)

        var intent: Intent = getIntent()
        txtProductName.text = intent.getStringExtra("productName")

        imgClose = findViewById(R.id.img_close)
        imgClose.setOnClickListener {
            finish()
        }

    }
}