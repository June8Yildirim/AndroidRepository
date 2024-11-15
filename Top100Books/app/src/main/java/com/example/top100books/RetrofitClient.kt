package com.example.top100books

import com.example.top100books.apiservices.WizardWorldApiServices
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


//
//object RetrofitClient {
//    private  const val BASE_URL ="https://wizard-world-api.herokuapp.com"
//    private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
//
//    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
//
//    val wizardWorldAPIServices : WizardWorldApiServices by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .client(okHttpClient)
//            .build().create(wizardWorldAPIServices::class.java)
//    }
//}