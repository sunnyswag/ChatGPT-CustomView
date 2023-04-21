package com.example.circlecustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.circlecustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.attendanceRateView.setPercentage(15.0f)

        setContentView(binding.root)
    }
}