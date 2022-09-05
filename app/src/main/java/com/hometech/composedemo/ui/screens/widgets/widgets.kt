package com.hometech.composedemo.ui.screens.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.hometech.composedemo.model.Book
import com.hometech.composedemo.model.getAllBooks

@Preview
@Composable
fun BookRow(book: Book = getAllBooks()[0], onItemClick: (String) -> Unit = {}) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(book.images[0])
            .crossfade(true) // Set the target size to load the image at.
            .build()
    )

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClick.invoke(book.title) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)), elevation = 5.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {

            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp), shape = RectangleShape, elevation = 4.dp
            ) {

                AsyncImage(
                    modifier = Modifier.size(124.dp),
                    model = "https://books.google.com/books/content?id=GxXGDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                    contentDescription = null
                )
//                Image(
//                    painter = painter,
//                    contentDescription = "Book Image"
//                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = book.title, style = MaterialTheme.typography.h6)
                Text(text = "Author: ${book.author}", style = MaterialTheme.typography.caption)
                Text(text = "Release ${book.publisherDate}", style = MaterialTheme.typography.caption)
            }
        }
    }
}