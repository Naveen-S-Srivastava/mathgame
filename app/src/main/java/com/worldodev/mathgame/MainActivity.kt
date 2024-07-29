package com.worldodev.mathgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var addition : Button
    lateinit var bsubstraction : Button
    lateinit var multi : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        addition = findViewById(R.id.buttonadd)
        bsubstraction = findViewById(R.id.buttonsub)
        multi = findViewById(R.id.buttonmulti)
        addition.setOnClickListener {
            var intent = Intent(this@MainActivity , GameActivity::class.java)
            startActivity(intent)
        }
        bsubstraction.setOnClickListener {
            var intent = Intent(this@MainActivity , substraction::class.java)
            startActivity(intent)


        }
        multi.setOnClickListener {
            var intent = Intent(this@MainActivity,Multiplication::class.java)
            startActivity(intent)
        }

    }
}