package com.hometech.composedemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hometech.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        ComposeDemoTheme {
            Scaffold(
                topBar = {
                    TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                        Text(
                            text = "Books",
                            style = MaterialTheme.typography.h6,
                            color = Color.White
                        )
                    }
                },
            ) {
                content.invoke()
            }
        }
    }


    @Composable
    fun MainContent(
        bookList: List<String> = listOf(
            "Book1",
            "Book2",
            "Book3",
            "Book4",
            "Book5",
            "Book6",
            "Book7",
            "Book8"
        )
    ) {
        LazyColumn {
            items(items = bookList) {
                BookRow(book = it) { book: String ->
                    Log.d("TAG", book)
                }
            }
        }
    }

    @Composable
    fun BookRow(book: String, onItemClick: (String) -> Unit = {}) {
        Card(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .height(130.dp)
                .clickable { onItemClick.invoke(book) },
            shape = RoundedCornerShape(corner = CornerSize(16.dp)), elevation = 5.dp
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {

                Surface(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(100.dp), shape = RectangleShape, elevation = 4.dp
                ) {
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Book Image")

                }
                Text(text = book)
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MyApp {
            MainContent()
        }
    }

}

