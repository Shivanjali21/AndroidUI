package com.practice.androidui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practice.androidui.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.apply {
            binding.apply {

            }
        }
    }
}