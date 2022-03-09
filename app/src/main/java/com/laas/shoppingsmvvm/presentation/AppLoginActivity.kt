package com.laas.shoppingsmvvm.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.laas.shoppingsmvvm.MainActivity
import com.laas.shoppingsmvvm.R
import com.laas.shoppingsmvvm.databinding.ActivityAppLoginBinding

class AppLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppLoginBinding
    private lateinit var BTN_LOGIN:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareFields()

    }

    private fun prepareFields(){
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()



        BTN_LOGIN = findViewById(R.id.btn_login)
        BTN_LOGIN.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}