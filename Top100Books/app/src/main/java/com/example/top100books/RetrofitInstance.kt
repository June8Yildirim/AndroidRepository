package com.example.top100books

import com.example.top100books.apiservices.WizardWorldApiServices
import com.example.top100books.apiservices.productsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client:OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(interceptor)
        .build()

    val api: productsApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(productsApi.BASE_URL)
        .client(client)
        .build()
        .create(productsApi::class.java)
}