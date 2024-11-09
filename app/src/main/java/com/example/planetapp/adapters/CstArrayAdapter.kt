package com.example.planetapp.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.planetapp.R
import com.example.planetapp.models.Planet


class CstArrayAdapter(
    private val context: Context,
    private var planets: Array<Planet>
) :
    ArrayAdapter<Planet?>(context, R.layout.planet_activity, planets) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup):
            View {

        val planet: Planet = getItem(position)!!

        var view: View
        val viewHolder: ViewHolder

        val inflater: LayoutInflater =  LayoutInflater.from(context)

        if (convertView == null) {

            viewHolder = ViewHolder
            view = inflater.inflate(R.layout.planet_activity,parent,false)

            viewHolder.planetImage = view.findViewById(R.id.planetImage)
            viewHolder.moonCount = view.findViewById(R.id.moonText)
            viewHolder.planetName = view.findViewById(R.id.planetName)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        Log.i("PLANETNAME",planet.getPlanet())
        val pName=planet.getPlanet()
        viewHolder.planetName?.text   = pName
        viewHolder.planetImage?.setImageResource(planet.getImage())
        viewHolder.moonCount?.text = planet.getMoonCount().toString()
        Log.i("ERROR",viewHolder.planetName?.text.toString())
        return view
    }


    companion object ViewHolder {
        var planetName: TextView? = null
        var planetImage: ImageView? = null
        var moonCount: TextView? = null
    }
}
