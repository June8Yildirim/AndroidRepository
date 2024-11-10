package com.example.cardviewadapter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewadapter.R
import com.example.cardviewadapter.models.Sport

class CstRecyclerAdapter(
    private var sportList:List<Sport>
) : RecyclerView.Adapter<CstRecyclerAdapter.SportsViewHolder>() {


//    public CstRecyclerAdapter(sports:List<Sport>){this.sportList = sports}
    inner class SportsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val sportImage: ImageView = itemView.findViewById(R.id.sport_image)
    val sportTitle : TextView = itemView.findViewById(R.id.sport_title)

    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sport :Sport = sportList[position]
        holder.sportTitle.text = sport.getTitle()
        holder.sportImage.setImageResource(sport.getImage())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.sport_item_layout,parent,false)
        return  SportsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return sportList.size
    }

}