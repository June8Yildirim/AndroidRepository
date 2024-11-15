package com.example.top100books.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.top100books.RetrofitClient
//import kotlinx.coroutines.launch
//
//class HouseModel:ViewModel() {
//    private val noData = MutableLiveData("No Data")
//    val realData : LiveData<String>get()=noData
//
//    init {
//        viewModelScope.launch { getHouse()  }
//    }
//    private suspend fun getHouse(){
//        noData.value = RetrofitClient.wizardWorldAPIServices.getHouses().toString()
//    }
//}