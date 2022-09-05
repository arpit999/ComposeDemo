package com.hometech.composedemo.ui.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hometech.composedemo.model.Book
import com.hometech.composedemo.model.getAllBooks
import com.hometech.composedemo.ui.navigation.BookAppFlow
import com.hometech.composedemo.ui.screens.widgets.BookRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.DarkGray, elevation = 5.dp) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Books",
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
        },
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    bookList: List<Book> = getAllBooks(),
    navController: NavController
) {
    LazyColumn {
        items(items = bookList) {
            BookRow(book = it) { book: String ->
                Log.d("TAG", book)
                navController.navigate(route = BookAppFlow.DetailsScreen.name + "/$book")
            }
        }
    }
}