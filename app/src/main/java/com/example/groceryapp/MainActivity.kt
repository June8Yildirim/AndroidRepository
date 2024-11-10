package com.example.groceryapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.groceryapp.adapter.ItemCstOnClickListener
import com.example.groceryapp.adapter.RecyclerAdapter
import com.example.groceryapp.models.Item


class MainActivity : ComponentActivity(), ItemCstOnClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemList: List<Item>
    private lateinit var recycleAdapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_act)
        recyclerView = findViewById(R.id.recycler_view)
        itemList = arrayListOf(
            Item(R.drawable.fruit, "Fruits", "Fresh Fruits from the Garden"),
            Item(R.drawable.vegitables, "Vegetables", "Delicious Vegetables "),
            Item(R.drawable.bread, "Bakery", "Bread, Wheat and Beans"),
            Item(R.drawable.beverage, "Beverage", "Juice, Tea, Coffee and Soda"),
            Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt"),
            Item(R.drawable.popcorn, "Snacks", "Pop Corn, Donut and Drinks"),
        )
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


        recycleAdapter = RecyclerAdapter(itemList)
        recyclerView.adapter = recycleAdapter


        recycleAdapter.setClickListener(this)

    }

    override fun onClick(v: View, pos: Int) {
        Toast.makeText(this,"You chose ${itemList[pos].getItemName()}",Toast.LENGTH_SHORT).show()
    }

}
