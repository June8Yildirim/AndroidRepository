package com.example.top25books

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_act)
        listView = findViewById(R.id.listView)
        val data = arrayOf("java", "javascript", "Go", "Rust", "C++", "C#")
        listView.adapter = Adapter(this, data)
        listView.isClickable = true
        listView.setOnItemClickListener() { parent, view, position, id ->
            Log.i("TEST",data[position])
            Toast.makeText(this, data[position], Toast.LENGTH_SHORT).show()
        }


//        listView.adapter = ArrayAdapter(this,R.layout.list_item, data)
//        var customAdapter: CustomAdapter = CustomAdapter(this, data)
//        var arrayAdapter  = ArrayAdapter(this,R.layout.list_item,data)
//        listView.adapter = arrayAdapter
//        listView.setAdapter(customAdapter)
//        listView.adapter = customAdapter;

    }

}