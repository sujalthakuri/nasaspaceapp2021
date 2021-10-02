package com.example.nasaspaceapp2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.nasaspaceapp2021.ui.DashboardActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnContinue : Button
    private lateinit var etName : EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnContinue = findViewById(R.id.btnContinue)
        etName = findViewById(R.id.etName)

        btnContinue.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }


    }
}