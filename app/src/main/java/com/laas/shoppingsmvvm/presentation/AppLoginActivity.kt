package com.laas.shoppingsmvvm.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.laas.shoppingsmvvm.MainActivity
import com.laas.shoppingsmvvm.databinding.ActivityAppLoginBinding

class AppLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareFields()

    }

    private fun prepareFields() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}