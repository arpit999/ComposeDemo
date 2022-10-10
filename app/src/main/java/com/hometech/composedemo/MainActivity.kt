package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.hometech.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                MyApp()
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun MyApp() {

        val imageList = listOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f)

        val pagerState = rememberPagerState()
        val currentImage = remember(pagerState) { mutableStateOf(R.drawable.a) }

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFF546E7A)
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Box() {
                    HorizontalPager(
                        modifier = Modifier
                            .fillMaxWidth(),
                        count = imageList.size, state = pagerState
                    ) { page ->
                        when (page) {
                            0 -> currentImage.value = imageList[0]
                            1 -> currentImage.value = imageList[1]
                            2 -> currentImage.value = imageList[2]
                            3 -> currentImage.value = imageList[3]
                            4 -> currentImage.value = imageList[4]
                            5 -> currentImage.value = imageList[5]
                            else -> currentImage.value = R.drawable.a
                        }
                        Image(
                            painterResource(currentImage.value),
                            contentScale = ContentScale.Fit,
                            contentDescription = "",
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Column {
                        Spacer(modifier = Modifier.padding(100.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp)
                        ) {
//                            LazyColumn {
//                                items(19) {
                            Column {
                                for (i in 1..10)
                                    Text(text = "Account $i", modifier = Modifier.padding(16.dp))
                            }
//                                }
//                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(16.dp))

                LazyRow(modifier = Modifier.padding(start = 8.dp,bottom = 16.dp)) {
                    items(10) {
                        Card {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "Jetpack"
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Compose"
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme {
            MyApp()
        }
    }

}