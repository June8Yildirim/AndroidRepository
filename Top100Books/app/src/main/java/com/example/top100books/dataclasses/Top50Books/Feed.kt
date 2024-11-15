package com.example.top100books.dataclasses.Top50Books

data class Feed(
    val author: Author,
    val copyright: String,
    val country: String,
    val icon: String,
    val id: String,
    val links: List<Link>,
    val results: List<Result>,
    val title: String,
    val updated: String
)