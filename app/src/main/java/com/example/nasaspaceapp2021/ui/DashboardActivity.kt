package com.example.nasaspaceapp2021.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nasaspaceapp2021.R

class DashboardActivity : AppCompatActivity() {
    private lateinit var btnMars : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        btnMars = findViewById(R.id.btnMars)

        btnMars.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }
    }
}