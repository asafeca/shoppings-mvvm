package com.laas.shoppingsmvvm.presentation

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.laas.shoppingsmvvm.databinding.ActivityAppLoginBinding

class AppLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppLoginBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.windowInsetsController!!.hide(
            android.view.WindowInsets.Type.statusBars()

        )
    }


}