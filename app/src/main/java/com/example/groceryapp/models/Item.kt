package com.example.groceryapp.models

class Item (
    private var itemImg:Int,
    private var itemName:String,
    private var itemDesc:String
){

    fun getItemName():String{
        return itemName
    }
    fun getItemDesc():String{
        return itemDesc
    }
    fun getItemImage():Int{
        return itemImg
    }
}