package com.example.shoppinglistapp.DataClass

data class ShoppingItem(
    var id: Int, var itemName: String, var quantity: Int, var isEditing: Boolean = false,
    var address: String = ""
)
