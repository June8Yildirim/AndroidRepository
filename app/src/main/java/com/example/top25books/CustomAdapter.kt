package com.example.top25books

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(private val context: Context, private val items: Array<String>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView: View? = convertView
        val holder: CustomAdapter.ViewHolder
        if (convertView == null) {
            var convertView: View? =convertView
            val holder:CustomAdapter.ViewHolder
            convertView = LayoutInflater.from(context).inflate(R.layout.main_act, parent, false)
        } else {
            holder = convertView.tag as CustomAdapter.ViewHolder
        }
        return convertView
    }

    internal class ViewHolder {
        var textView: TextView? = null
    }
}
