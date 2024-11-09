package com.example.mathcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.mathcalculator.databinding.ActivityCylinderCalculationBinding

class CylinderCalculation : AppCompatActivity() {

    private lateinit var binding: ActivityCylinderCalculationBinding
    private lateinit var cylinderHeightInput: EditText
    private lateinit var cylinderRadiusInput: EditText
    private lateinit var cylinderResult: TextView
    private lateinit var cylinderCalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCylinderCalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        cylinderResult = findViewById(R.id.cylinder_result)
        cylinderCalc = findViewById(R.id.cylinder_calculate)
        cylinderHeightInput = findViewById(R.id.cylinder_height_input)
        cylinderRadiusInput = findViewById(R.id.cylinder_radius_input)

        cylinderCalc.setOnClickListener{v->
            val heightConversation = Integer.parseInt(cylinderHeightInput.text.toString())
            val radiusConversation = Integer.parseInt(cylinderRadiusInput.text.toString())

            val result= Math.PI * Math.pow(radiusConversation.toDouble(),2.0)* heightConversation
            cylinderResult.text = result.toString()
        }



    }


}