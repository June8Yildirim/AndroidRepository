package com.cuneyt.quizapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var userNameEditText: EditText
    private lateinit var startButton: Button
    private lateinit var userErrorMessage: TextView
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var username :String = ""
        userNameEditText = findViewById(R.id.user_name)
        userErrorMessage = findViewById(R.id.errorMessage)
        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener({
            if (userNameEditText.text.isEmpty()) {
                Toast.makeText(this, "Enter User Name", Toast.LENGTH_SHORT).show()
                userErrorMessage.text = "Input cannot be empty"
            }else{
                username = userNameEditText.text.toString()
                userErrorMessage.text = username
                intent = Intent(this,QuestionsLayout::class.java)
                intent.putExtra("username",username)
                startActivity(intent)
            }

        })


    }
}