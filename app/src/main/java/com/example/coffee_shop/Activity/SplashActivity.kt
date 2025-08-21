package com.example.coffee_shop.zhmp.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coffee_shop.MainActivity
import com.example.coffee_shop.R
import com.example.coffee_shop.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

     lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.startBtn.setOnClickListener {
startActivity(Intent(this,MainActivity::class.java))
        }

    }
}