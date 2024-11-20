package com.cuneyt.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.withStarted
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.cuneyt.quizapp.databinding.ActivityResultBinding

class activityResult : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var username_res:TextView
    private lateinit var score:TextView
    private lateinit var finishBtn:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        username_res = findViewById(R.id.res_username)
        score= findViewById(R.id.score)
        finishBtn = findViewById(R.id.btn_finish)
        val intent = getIntent()
        val username = intent.getStringExtra("username")
        val correctAnswers= intent.getStringExtra("correctAnswers")

        username_res.text = "User name" + username
        score.text = "Score: ${correctAnswers}"

        finishBtn.setOnClickListener{
          val  intent_restart = Intent(this,MainActivity::class.java)
            startActivity(intent_restart)
        }
    }


}