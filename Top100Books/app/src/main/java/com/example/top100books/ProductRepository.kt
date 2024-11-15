package com.example.top100books

import com.example.top100books.dataclasses.Products.Product
import com.example.top100books.dataclasses.Products.Products
import kotlinx.coroutines.flow.Flow


interface ProductRepository {
    suspend fun getProductsList(): Flow<Result<List<Product>>>
}