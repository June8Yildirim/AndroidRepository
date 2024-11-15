package com.example.mealproject

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

var baseUrl:String = "https://www.themealdb.com/api/json/v1/1/"

fun getClient(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeServices = getClient().create(ApiServices::class.java)

//val okHttpClient = OkHttpClient().newBuilder().addInterceptor(RequestInterceptor).build()
//object RequestInterceptor : Interceptor{
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//        println("Outgoing request to ${request.url}")
//        return chain.proceed(request)
//    }
//}
interface ApiServices {
    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse
}