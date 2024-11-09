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
import com.example.mathcalculator.databinding.ActivityPrismCalculationBinding

class PrismCalculation : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPrismCalculationBinding
    private lateinit var prismHeightInput: EditText
    private lateinit var prismLengthInput: EditText
    private lateinit var prismWidthInput: EditText
    private lateinit var prismResult: TextView
    private lateinit var prismCalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrismCalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        prismWidthInput= findViewById(R.id.prism_w_input)
        prismLengthInput= findViewById(R.id.prism_l_input)
        prismHeightInput =findViewById(R.id.prism_h_input)
        prismResult = findViewById(R.id.prism_result)
        prismCalc = findViewById(R.id.prism_calculate)


        prismCalc.setOnClickListener{v->
            val wConversion = Integer.parseInt(prismWidthInput.text.toString())
            val hConversion = Integer.parseInt(prismHeightInput.text.toString())
            val lConversion = Integer.parseInt(prismLengthInput.text.toString())
            val result = wConversion * lConversion * hConversion
            prismResult.text = result.toString()
        }
    }

}