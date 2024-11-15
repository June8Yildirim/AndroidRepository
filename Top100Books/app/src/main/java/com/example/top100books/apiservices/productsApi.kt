package com.example.top100books.apiservices

import com.example.top100books.dataclasses.Products.Products
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface productsApi {

    @GET("products")
    suspend fun getProducts(): Products

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}

//
//@GET("products/{type}")
//suspend fun getProducts(
//    @Path("type") type:String,
//    @Query("page")page: Int,
//    @Query("api_key")apiKey:String
//):Products
//companion object{
//    const val BASE_URL = "https://dummyjson.com/"
//}