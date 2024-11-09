package com.example.planetapp

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.planetapp.adapters.CstArrayAdapter
import com.example.planetapp.models.Planet
import com.example.planetapp.ui.theme.PlanetappTheme

class MainActivity : ComponentActivity() {
    private lateinit var planetsView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.main_activity)
        planetsView = findViewById(R.id.planet_list)

        val planets: Array<Planet> = arrayOf(
            Planet(
                planet = "Mercury",
                moons = 0,
                planetImage = R.drawable.mercury,
                moonList = arrayOf()
            ),
            Planet(
                planet = "Venus",
                moons = 0,
                planetImage = R.drawable.venus,
                moonList = arrayOf()
            ),
            Planet(
                planet = "Earth",
                moons = 1,
                planetImage = R.drawable.earth,
                moonList = arrayOf("Moon")
            ),
            Planet(
                planet = "Mars",
                moons = 2,
                planetImage = R.drawable.mars,
                moonList = arrayOf("Phobos", "Deimos")
            ),
            Planet(
                planet = "Jupiter",
                moons = 79,
                planetImage = R.drawable.jupiter,
                moonList = arrayOf("IO", "Europa", "Ganymede", "Calisto")
            ),
            Planet(
                planet = "Saturn",
                moons = 62,
                planetImage = R.drawable.saturn,
                moonList = arrayOf("Titan", "Enceladus", "Dione")
            ),
            Planet(
                planet = "Uranus",
                moons = 27,
                planetImage = R.drawable.uranus,
                moonList = arrayOf("Titania", "Oberon")
            ),
            Planet(
                planet = "Neptune",
                moons = 14,
                planetImage = R.drawable.neptune,
                moonList = arrayOf("Triton")
            ),
            Planet(
                planet = "Pluto",
                moons = 5,
                planetImage = R.drawable.pluto,
                moonList = arrayOf()
            ),
        )

        planetsView.adapter = CstArrayAdapter(this, planets)

        planetsView.setOnItemClickListener() { parent, view, position, id ->
            Log.i("TEST", planets[position].getPlanet())
            Toast.makeText(this, planets[position].getPlanet(), Toast.LENGTH_SHORT).show()

        }
    }
}
