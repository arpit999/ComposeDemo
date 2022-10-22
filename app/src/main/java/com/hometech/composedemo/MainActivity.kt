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
import androidx.compose.runtime.*
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
import com.hometech.composedemo.ui.Theme
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

//        val imageList = listOf(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f)

        val themeList = listOf(
            Theme(R.drawable.a, Color(105, 44, 43), Color(225, 144, 143)),
            Theme(R.drawable.b, Color(4, 68, 108), Color(240, 240, 240)),
            Theme(R.drawable.c, Color(57, 129, 188), Color(212, 219, 230, 255)),
            Theme(R.drawable.d, Color(9, 50, 107), Color(249, 107, 42, 255)),
            Theme(R.drawable.e, Color(53, 56, 56), Color(199, 179, 152)),
            Theme(R.drawable.f, Color(93, 67, 151), Color(188, 118, 191))
        )

        val pagerState = rememberPagerState()
        var currentTheme by remember { mutableStateOf(themeList[0]) }
        val scroll = rememberScrollState()
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFF546E7A)
        ) {

            ConstraintLayout(modifier = Modifier.verticalScroll(scroll)) {

                // Create guideline from the top of the parent at 20% the height of the Composable
                val startGuideline = createGuidelineFromTop(0.37f)
                val (viewPager, accountList, spacer, insightCards) = createRefs()

                HorizontalPager(
                    modifier = Modifier
                        .constrainAs(viewPager) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                    count = themeList.size,
                    state = pagerState
                ) {
                    // currentPage Documentation says that this will be not accurate information that we are seeing on the screen.
                    currentTheme = themeList[pagerState.currentPage]

                    Image(
                        painterResource(currentTheme.themeCard),
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
                        for (i in 1..5)
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
                        Card(backgroundColor = currentTheme.backgroundColor) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = "Jetpack", color = currentTheme.fontColor)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Compose", color = currentTheme.fontColor)
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