package com.example.planetapp.models

class Planet constructor(
    private var planet:String,
    private var moonList:Array<String>,
    private var moons: Int,
    private var planetImage:Int
) {
    fun getImage():Int{
        return planetImage
    }
    fun getPlanet():String{
        return planet
    }
    fun getMoonList():Array<String>?{
        return moonList
    }
    fun getMoonCount():Int{
        return moons
    }
    fun getMoon(idx:Int):String{ return moonList.get(idx)
    }

}