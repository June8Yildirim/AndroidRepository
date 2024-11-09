package com.example.mathcalculator.models

class Shape (
    private val shapeImg:Int,
    private val shapeName:String
){
    fun getShapeName():String{
        return shapeName
    }
    fun getShapeImage():Int{
        return shapeImg
    }
}