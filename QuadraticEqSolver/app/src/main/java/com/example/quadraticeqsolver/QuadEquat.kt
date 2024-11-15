package com.example.quadraticeqsolver

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.quadraticeqsolver.databinding.MainActivityBinding

//data class QuadEquat(
//    private val binding: MainActivityBinding
//) : BaseObservable() {
//
//    @get:Bindable
//    var a: String =""
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.a)
//        }
//
//    @get:Bindable
//    var b: String=""
//        set(value) {
//    field = value
//            notifyPropertyChanged(BR.b)
//        }
//
//    @get:Bindable
//    var c: String = ""
//        set(value) {
//            field = value
//            notifyPropertyChanged(BR.c)
//        }
//
//    fun solveEquation(view: View) {
//        val aInt: Int = a.toInt()
//        val bInt: Int = b.toInt()
//        val cInt: Int = c.toInt()
//        val discrimination: Double = (bInt * bInt - 4 * aInt * cInt).toDouble()
//        val x1: Double
//        val x2: Double
//        if (discrimination > 0) {
//            x1 = (-bInt + Math.sqrt(discrimination)) / 2 * aInt
//            x2 = (-bInt - Math.sqrt(discrimination)) / 2 * aInt
//            binding.result.text = "X1= $x1, X2= $x2"
//        } else if (discrimination < 0) {
//            binding.result.text = "No Real Root"
//        } else {
//            // Discriminant = 0
//            // One real solution (double root)
//            x1 = (-bInt / (2 * aInt)).toDouble()
//            binding.result.text = "x = $x1"
//        }
//    }
//}