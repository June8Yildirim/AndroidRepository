package com.example.top100books.apiservices

import com.example.top100books.dataclasses.Top50Books.Books
import retrofit2.Call
import retrofit2.http.GET

interface BooksApi {
@GET("/books")
fun getBooks(): Call<Books>
}