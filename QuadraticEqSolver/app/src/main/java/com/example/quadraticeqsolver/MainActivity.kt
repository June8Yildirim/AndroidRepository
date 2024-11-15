package com.example.quadraticeqsolver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.databinding.DataBindingUtil
import com.example.quadraticeqsolver.databinding.MainActivityBinding

class MainActivity : ComponentActivity() {
    private lateinit var mainActivityBinding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)

        mainActivityBinding = DataBindingUtil.setContentView(
            this,
            R.layout.main_activity)

        var equation = QuadEquation(mainActivityBinding)
        mainActivityBinding.quadequation= equation
    }
}
