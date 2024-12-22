package com.practice.androidui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practice.androidui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.apply {
            binding.apply {

            }
        }
    }
}