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
import androidx.constraintlayout.compose.ConstraintLayout
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
        val scroll = rememberScrollState()
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFF546E7A)
        ) {

            ConstraintLayout(modifier = Modifier.verticalScroll(scroll)) {

                // Create guideline from the top of the parent at 30% the height of the Composable
                val startGuideline = createGuidelineFromTop(0.2f)
                val (viewPager, accountList, spacer, insightCards) = createRefs()

                HorizontalPager(
                    modifier = Modifier
                        .constrainAs(viewPager) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
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
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Card(
                    modifier = Modifier
                        .constrainAs(accountList) {
                            start.linkTo(parent.start)
                            top.linkTo(startGuideline)
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 28.dp), elevation = 12.dp
                ) {
                    Column {
                        for (i in 1..15)
                            Text(text = "Account $i", modifier = Modifier.padding(16.dp))
                    }
                }

                Spacer(modifier = Modifier
                    .constrainAs(spacer) {
                        start.linkTo(parent.start)
                        top.linkTo(accountList.bottom)
                    }
                    .padding(16.dp))

                LazyRow(modifier = Modifier
                    .constrainAs(insightCards) {
                        start.linkTo(parent.start)
                        top.linkTo(spacer.bottom)
                    }
                    .padding(start = 8.dp, bottom = 16.dp)
                ) {
                    items(10) {
                        Card {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = "Jetpack")
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Compose")
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