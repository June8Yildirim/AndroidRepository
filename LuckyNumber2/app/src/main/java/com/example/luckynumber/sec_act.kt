package com.example.luckynumber

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.luckynumber.databinding.ActivitySecBinding

class sec_act : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecBinding
    private lateinit var luckyNumberShow:TextView
    private lateinit var userNameShow:TextView
    private lateinit var intent: Intent;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        luckyNumberShow = findViewById(R.id.txtluckynumber)
        userNameShow = findViewById(R.id.txtusername)
        intent = getIntent()
        val username = intent.getStringExtra("userName")
        val luckNumber = intent.getStringExtra("luckyNumber")

        Log.i("USERNAME",username.toString())
        Log.i("LUCKYNUMBER",luckNumber.toString())

        luckyNumberShow.append(" "+luckNumber.toString())
        userNameShow.setText(" "+username.toString())

//        val navController = findNavController(R.id.nav_host_fragment_content_sec)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_sec)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}