package com.example.cardviewadapter.models

class Sport (
    private var title:String,
    private var image:Int,
) {
    fun getImage():Int{
        return image
    }
    fun getTitle():String{
        return title
    }
}