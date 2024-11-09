package com.example.mathcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mathcalculator.databinding.ActivitySphereCalculationBinding

class SphereCalculation : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySphereCalculationBinding
    private lateinit var sphereRadius: EditText
    private lateinit var sphereResult: TextView
    private lateinit var sphereCalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySphereCalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        sphereCalc = findViewById(R.id.sphere_calculate)
        sphereResult = findViewById(R.id.sphere_result)
        sphereRadius = findViewById(R.id.sphere_radius)

        sphereCalc.setOnClickListener{v->
            val radius = Integer.parseInt(sphereRadius.text.toString())
            val result = 4 * Math.PI * Math.pow(radius.toDouble(),2.0)
            sphereResult.text = result.toString()
        }
    }

}