package com.laas.shoppingsmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.laas.shoppingsmvvm.R

class DetailsActivity : AppCompatActivity() {

    private lateinit var imgClose:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        prepareFields()

    }

    private fun prepareFields(){
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        imgClose = findViewById(R.id.img_close)
        imgClose.setOnClickListener{
            finish()
        }

    }
}