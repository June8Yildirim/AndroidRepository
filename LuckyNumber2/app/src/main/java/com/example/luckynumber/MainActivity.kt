package com.example.luckynumber

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private lateinit var inputText: EditText;
    private lateinit var header: TextView;
    private lateinit var getLuckyNumber: Button;
    private var luckyNumber: Int? = null;
    private lateinit var intent: Intent;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        enableEdgeToEdge()

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.VANILLA_ICE_CREAM){
            val window: Window= this.window
            window.setStatusBarColor(this.resources.getColor(R.color.purple_200))
        }
        inputText = findViewById(R.id.userInput)
        header = findViewById(R.id.welcome)
        getLuckyNumber = findViewById(R.id.luckynumber)

        getLuckyNumber.setOnClickListener { v ->
            if (inputText.text.isNotEmpty()) {
                luckyNumber = Random.nextInt(0, 100)
                header.append(" ${luckyNumber.toString()}")
                moveActivity()
            } else {
                Toast.makeText(applicationContext, "Enter your name first", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    fun moveActivity(){
        intent = Intent(this,sec_act::class.java)
        intent.putExtra("userName",inputText.text.toString())
        intent.putExtra("luckyNumber",luckyNumber.toString())
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu,menu)
        return true
    }
}

