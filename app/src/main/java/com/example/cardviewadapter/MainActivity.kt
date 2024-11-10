package com.example.cardviewadapter

import android.os.Bundle
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.cardviewadapter.adapters.CstRecyclerAdapter
import com.example.cardviewadapter.models.Sport
import com.example.cardviewadapter.ui.theme.CardViewAdapterTheme

class MainActivity : ComponentActivity() {
    private lateinit var sportRecycView: RecyclerView
    private lateinit var sportsAdapter: CstRecyclerAdapter
    private lateinit var sports: List<Sport>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)
sportRecycView = findViewById(R.id.recyclerView)
        sports = listOf(
            Sport("Football", R.drawable.football),
            Sport("Basketball", R.drawable.basketball),
            Sport("VolleyBall", R.drawable.volley),
            Sport("Tennis", R.drawable.tennis),
            Sport("Ping Pong", R.drawable.ping),
        )

        sportsAdapter =CstRecyclerAdapter(sports)
        sportRecycView.layoutManager= LinearLayoutManager(this)
        sportRecycView.adapter = sportsAdapter
    }
}
