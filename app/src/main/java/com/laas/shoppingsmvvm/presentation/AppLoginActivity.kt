package com.laas.shoppingsmvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.laas.shoppingsmvvm.databinding.ActivityAppLoginBinding

class AppLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}