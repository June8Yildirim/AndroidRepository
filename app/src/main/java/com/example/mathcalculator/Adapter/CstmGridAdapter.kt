package com.example.mathcalculator.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mathcalculator.R
import com.example.mathcalculator.models.Shape

class CstmGridAdapter(context: Context, shapes: ArrayList<Shape>) :
    ArrayAdapter<Shape>(context, R.layout.grid_item_layout, shapes) {

    private var shapesArrayList: ArrayList<Shape> = shapes
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val shape: Shape = getItem(position)!!

        var view: View
        val viewHolder: ViewHolder
        var inflater: LayoutInflater = LayoutInflater.from(context)

        if (convertView == null) {
            viewHolder = ViewHolder
            view = inflater.inflate(R.layout.grid_item_layout, parent, false)
            viewHolder.shapeImage = view.findViewById(R.id.shapeImg)
            viewHolder.shapeTitle = view.findViewById(R.id.shapeTitle)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        Log.i("HOLDER1",viewHolder.shapeTitle?.text.toString())
        viewHolder.shapeImage?.setImageResource(shape.getShapeImage())
        viewHolder.shapeTitle?.text = shape.getShapeName()

        Log.i("HOLDER2",viewHolder.shapeTitle?.text.toString())
        return view
    }

    companion object ViewHolder {
        var shapeImage: ImageView? = null
        var shapeTitle: TextView? = null
    }

}