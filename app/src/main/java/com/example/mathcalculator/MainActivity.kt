 package com.example.mathcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
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
import com.example.mathcalculator.Adapter.CstmGridAdapter
import com.example.mathcalculator.models.Shape
import com.example.mathcalculator.ui.theme.MathCalculatorTheme

class MainActivity : ComponentActivity() {
    private lateinit var gridView: GridView
    private lateinit var cstAdapter:CstmGridAdapter
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_act)

        val shapeList:ArrayList<Shape> = arrayListOf(
            Shape(R.drawable.cube,"Cube"),
            Shape(R.drawable.cylinder,"Cylinder"),
            Shape(R.drawable.sphere,"Sphere"),
            Shape(R.drawable.prism,"Prism"))

        gridView = findViewById(R.id.gridView)

        cstAdapter = CstmGridAdapter(this,shapeList)

        gridView.adapter =cstAdapter
        gridView.numColumns=2


        gridView.setOnItemClickListener(){p,v,po,id->
            Toast.makeText(this,shapeList[po].getShapeName(),Toast.LENGTH_SHORT).show()
            var shapeName= shapeList[po].getShapeName()
//            if(shapeName== "Cube"){
//                intent = Intent(this,CubeCalculation::class.java)
//            }else if (shapeName == "Sphere"){
         when(shapeName){
             "Cube"-> intent = Intent(this,CubeCalculation::class.java)
             "Sphere"-> intent = Intent(this,SphereCalculation::class.java)
             "Cylinder"-> intent = Intent(this,CylinderCalculation::class.java)
             "Prism"-> intent = Intent(this,PrismCalculation::class.java)
         }
            startActivity(intent)
        }

    }
}
