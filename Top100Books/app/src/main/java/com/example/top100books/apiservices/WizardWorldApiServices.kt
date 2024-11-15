package com.example.top100books.apiservices

import com.example.top100books.dataclasses.houses.houses
import retrofit2.http.GET

interface WizardWorldApiServices {
    @GET("/Houses")
    suspend fun  getHouses():List<houses>

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}