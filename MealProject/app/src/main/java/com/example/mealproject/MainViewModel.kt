package com.example.mealproject

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _catState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _catState

    init {
        fetchCategories()
    }
    private fun fetchCategories() {
        viewModelScope.launch {
            try {

                val response = recipeServices.getCategories()
                _catState.value = _catState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null,
                )
            } catch (e: Exception) {
                _catState.value = _catState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null

    )
}