package com.example.circlecustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.circlecustomview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btResetProgress.setOnClickListener {
            binding.attendanceRateView.setPercentage(0)
        }

        binding.btChangeProgress.setOnClickListener {
            binding.attendanceRateView.animatePercentage(60)
        }

        setContentView(binding.root)
    }
}