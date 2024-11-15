package com.example.mealproject

import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier=Modifier,
                 viewState: MainViewModel.RecipeState,
                 navigateToDetail: (Category) -> Unit
                 ){
//    val recipeViewModel :MainViewModel = viewModel()
//    val viewState by recipeViewModel.categoriesState

    Box(modifier = Modifier.fillMaxSize())
    {
        when{
            viewState.loading->{
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            viewState.error != null->{
                Text("Error Occured")
            }else -> {
                CategoryScreen(categories = viewState.list, navigateToDetail)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>, navigateToDetail: (Category) -> Unit){
    LazyVerticalGrid(GridCells.Fixed(2),
        modifier = Modifier
            .statusBarsPadding()
            .systemBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize()) {
        items(categories){category->
            CategoryItem(category=category, navigateToDetail)
        }
    }
}

@Composable
fun CategoryItem(category: Category,
                 navigateToDetail: (Category)->Unit
){
    Row (
        modifier = Modifier
            .padding(2.dp)
            .background(Color.Cyan)
    ){
    Column(modifier = Modifier
        .padding(5.dp)
        .background(Color.LightGray)
        .fillMaxSize()
        .clickable { navigateToDetail(category) },
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier =Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(
            text=category.strCategory,
            color = Color.DarkGray,
            style= TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            modifier = Modifier.padding(top=1.dp)

        )
    }
    }
}