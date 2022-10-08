package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
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

    @OptIn(ExperimentalPagerApi::class, ExperimentalCoilApi::class)
    @Composable
    fun MyApp() {

        val imageList = listOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f)

        val pagerState = rememberPagerState()
        val currentImage = remember(pagerState) { mutableStateOf(R.drawable.a) }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xFF546E7A)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                HorizontalPager(count = imageList.size, state = pagerState) { page ->
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
                        modifier = Modifier.
                            fillMaxWidth()
                    )
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