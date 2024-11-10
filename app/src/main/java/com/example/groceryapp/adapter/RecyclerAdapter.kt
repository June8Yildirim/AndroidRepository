package com.example.groceryapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R
import com.example.groceryapp.models.Item

class RecyclerAdapter(
    var itemList: List<Item>
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
//    private lateinit var itemList: List<Item>

    private lateinit var clickListener: ItemCstOnClickListener;

    fun setClickListener(listener: ItemCstOnClickListener) {
        clickListener = listener
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = itemList[position]
        val title = viewHolder.title
        val description = viewHolder.description
        val image = viewHolder.imageView

        title.text = item.getItemName()
        description.text = item.getItemDesc()
        image.setImageResource(item.getItemImage())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return ViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{
        val imageView: ImageView = itemView.findViewById(R.id.image_item)
        val title: TextView = itemView.findViewById(R.id.item_title)
        val description: TextView = itemView.findViewById(R.id.item_description)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if(clickListener != null){
                clickListener.onClick(v, adapterPosition)
            }
        }

//        override fun onClick(v: View, pos: Int) {
//            if(clickListener != null){
//                clickListener.onClick(v, adapterPosition)
//            }
//        }

    }
}