 package com.example.mathcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mathcalculator.ui.theme.MathCalculatorTheme

class MainActivity : ComponentActivity() {
    private lateinit var btn_cylinder:Button;
    private lateinit var btn_prism:Button;
    private lateinit var btn_cube:Button;
    private lateinit var btn_sphere:Button;
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_act)

        btn_prism = findViewById(R.id.btn_prism_calculation)
        btn_cube= findViewById(R.id.btn_cube_calculation)
        btn_cylinder= findViewById(R.id.btn_cylinder_calculation)
        btn_sphere= findViewById(R.id.btn_sphere_calculation)


        btn_cylinder.setOnClickListener{
//            Toast.makeText(this@MainActivity, "Cylinder Clicked",Toast.LENGTH_SHORT).show()
            intent = Intent(this,CylinderCalculation::class.java)
            startActivity(intent)
        }
        btn_prism.setOnClickListener{
//            Toast.makeText(this@MainActivity, "Prism Clicked",Toast.LENGTH_SHORT).show()
            intent = Intent(this,PrismCalculation::class.java)
            startActivity(intent)
        }
        btn_cube.setOnClickListener{
//            Toast.makeText(this@MainActivity, "Cube Clicked",Toast.LENGTH_SHORT).show()
            intent = Intent(this,CubeCalculation::class.java)
            startActivity(intent)
        }
       btn_sphere.setOnClickListener{
//            Toast.makeText(this@MainActivity, "Sphere Clicked",Toast.LENGTH_SHORT).show()
           intent = Intent(this,SphereCalculation::class.java)
           startActivity(intent)
        }

    }
}
