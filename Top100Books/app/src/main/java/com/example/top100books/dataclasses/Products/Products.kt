package com.example.top100books.dataclasses.Products

data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)
