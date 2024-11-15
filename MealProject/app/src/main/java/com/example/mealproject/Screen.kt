package com.example.mealproject

sealed  class Screen(val route:String) {

    object RecipeScreen:Screen("recipescreen")
    object RecipeDetailScreen:Screen("detailscreen")


}