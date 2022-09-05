package com.hometech.composedemo.ui.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, bookData: String?) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.DarkGray, elevation = 5.dp) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Icon(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { navController.popBackStack() },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back", tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = "Book Detail",
                        style = MaterialTheme.typography.h6,
                        color = Color.White
                    )
                }
            }
        },
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = bookData.toString(), style = MaterialTheme.typography.h5)
            }
        }
    }

}