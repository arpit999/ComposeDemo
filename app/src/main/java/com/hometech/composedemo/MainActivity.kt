package com.hometech.composedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.hometech.composedemo.ui.Account
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

        val accountList = listOf(
            Account(name = "PETER STEEDMAN", amount = "$1,340.02"),
            Account(name = "STAN KOZA", amount = "$14,754.77"),
            Account(name = "Long Term GIC", amount = "$102,742.49"),
            Account(name = "RSP Advantage Account", amount = "$150,908.35"),
            Account(name = "STAN KOZA", amount = "$14,754.77"),
            Account(name = "Long Term GIC", amount = "$102,742.49"),
            Account(name = "RSP Advantage Account", amount = "$150,908.35"),
        )

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
        val context = LocalContext.current

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFF546E7A)
        ) {

            ConstraintLayout(modifier = Modifier.verticalScroll(scroll)) {

                // Create guideline from the top of the parent at 250dp the height of the Composable or I can also pass float values as a percentage of the height
                val startGuideline = createGuidelineFromTop(250.dp)
                val (viewPager, list, spacer, insightCards) = createRefs()

                HorizontalPager(
                    modifier = Modifier
                        .constrainAs(viewPager) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                    count = themeList.size,
                    state = pagerState
                ) {
                    // Require this due to compositions
                    LaunchedEffect(key1 = pagerState) {
                        currentTheme = themeList[pagerState.currentPage]
                    }

                    Image(
                        painterResource(themeList[it].themeCard),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Card(
                    modifier = Modifier
                        .constrainAs(list) {
                            start.linkTo(parent.start)
                            top.linkTo(startGuideline)
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 28.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    elevation = 12.dp
                ) {
                    Column {
                        Text(
                            text = "DEPOSITS",
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 4.dp),
                            fontSize = 12.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Light
                        )
                        GenerateAccountList(accountList) {
                            Toast.makeText(context, " ${it.name} has ${it.amount}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                Spacer(modifier = Modifier
                    .constrainAs(spacer) {
                        start.linkTo(parent.start)
                        top.linkTo(list.bottom)
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

    @Composable
    private fun GenerateAccountList(accountList: List<Account>, onClick: (Account) -> Unit) {
        for ((index, value) in accountList.withIndex()) {
            Row(
                Modifier.clickable { onClick.invoke(value) },
                verticalAlignment = CenterVertically,
            ) {
                val modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 24.dp)
                    .padding(top = 8.dp, bottom = 8.dp)

                Text(
                    text = value.name,
                    modifier = modifier
                        .wrapContentWidth(Alignment.Start),
                    fontSize = 12.sp
                )
                Text(
                    text = value.amount,
                    modifier = modifier
                        .wrapContentWidth(Alignment.End),
                    fontSize = 12.sp
                )
            }
            if (index <= accountList.size - 2) {
                Divider(
                    thickness = 0.3.dp,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
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