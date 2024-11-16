package com.example.shoppinglistapp.ViewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.viewbinding.BuildConfig
import com.example.shoppinglistapp.Api.RetrofitClient
import com.example.shoppinglistapp.DataClass.GeocodingResult
import com.example.shoppinglistapp.DataClass.LocationData
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

class LocationViewModal :ViewModel(){

    private var _location = mutableStateOf<LocationData?>(null)
    val location : State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeocodingResult>())
    val address:State<List<GeocodingResult>> = _address

    fun updateLocation(newLocation: LocationData){
        _location.value = newLocation
    }

    fun fetchAddress(latLng: String){
        val apiKey= ""

        try {
            viewModelScope.launch {
                Log.d("---------------",latLng.toString())
                Log.d("---------------",apiKey)
 val result = RetrofitClient.create().getAddressFromCoordinates(latLng,apiKey)
                _address.value = result.results
                Log.d("API-------------",result.results.toString())
            }
        }catch (e:Exception){
            Log.e("FETCH_ADDRESS","${e.cause} ${e.message}")
        }

    }
}