package com.cuneyt.quizapp

import androidx.resourceinspection.annotation.Attribute.IntMap

data class Question(
    val id:Int,
    val question:String,
    val image:Int,
    val opt1:String,
    val opt2:String,
    val opt3:String,
    val opt4:String,
    val answer: Int
)
