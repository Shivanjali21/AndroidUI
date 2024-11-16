package com.practice.androidui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practice.androidui.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.apply {
          tvSubTitle.setOnClickListener {
             startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
          }
       }
    }
}