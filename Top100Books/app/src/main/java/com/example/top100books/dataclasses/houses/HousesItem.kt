package com.example.top100books.dataclasses.houses

data class housesItem(
    val animal: String,
    val commonRoom: String,
    val element: String,
    val founder: String,
    val ghost: String,
    val heads: List<Head>,
    val houseColours: String,
    val id: String,
    val name: String,
    val traits: List<Trait>
)