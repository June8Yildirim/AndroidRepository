package com.example.weatherapplication.DataClass


data class GeocodingResponse(
    val results: List<GeocodingResult>,
    val status: String
)

data class GeocodingResult(
    val formattedAddress: String
)