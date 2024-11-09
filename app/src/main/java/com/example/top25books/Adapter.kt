package com.example.top25books

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import kotlin.contracts.contract

class Adapter(
    private val context: Context,
    private val data: Array<String>
) : BaseAdapter()
//ArrayAdapter<String>(context,R.layout.list_item,data)
{
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //    private val inflater : LayoutInflater = LayoutInflater.from(context).inflate(data,R.layout.main_act,false)
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if (p1 == null) {
            view = inflater.inflate(R.layout.list_item, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = p1
            viewHolder = view.tag as ViewHolder
        }
        var dto = data[p0]

        viewHolder.lang?.text = dto
        return view as View
    }

    //    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val inflater :LayoutInflater = LayoutInflater.from(context)
//        val  view:View= inflater.inflate(R.layout.main_act,parent)
//        return view
//    }
    private class ViewHolder(row: View?) {
        var lang: TextView? = null

        init {
            this.lang = row?.findViewById<TextView>(R.id.textview)
        }
    }
}