package com.example.mathcalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mathcalculator.databinding.ActivityCubeCalculationBinding
import kotlin.reflect.typeOf

class CubeCalculation : AppCompatActivity() {

    private lateinit var binding: ActivityCubeCalculationBinding
    private lateinit var cubeInput: EditText
    private lateinit var cubeResult: TextView
    private lateinit var cubeCalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCubeCalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        cubeInput = findViewById(R.id.cube_input)
        cubeCalc = findViewById(R.id.cube_calculate)
        cubeResult =findViewById(R.id.cube_result)
        cubeResult.text = cubeInput.text

//        val result = Math.pow(conversion,3.0)
        cubeCalc.setOnClickListener { v ->
            val conversion = Integer.parseInt(cubeInput.text.toString())
            val result = Math.pow(conversion.toDouble(), 3.0)
            cubeResult.text = result.toString()
            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()
        }


    }


}