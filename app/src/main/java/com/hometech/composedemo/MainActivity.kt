package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene

@OptIn(ExperimentalMotionApi::class)
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lazyScrollState = rememberLazyListState()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                topBar = {
                    CollapsingToolbar(lazyScrollState)
                },
            ) { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White)
                            .animateContentSize(),
                        state = lazyScrollState
                    ) {
                        // Add 5 items
                        items(100) { index ->
                            Text(modifier = Modifier.padding(36.dp), text = "Item: $index")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun CollapsingToolbar(lazyScrollState: LazyListState) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.collapse_toolbar).readBytes().decodeToString()
    }

    val progress by animateFloatAsState(
        targetValue = if (lazyScrollState.firstVisibleItemIndex in 0..1) 0f else 1f,
        tween(500)
    )
    val motionHeight by animateDpAsState(
        targetValue = if (lazyScrollState.firstVisibleItemIndex in 0..1) 230.dp else 56.dp,
        tween(500)
    )

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .height(motionHeight)
    ) {

//        val boxProperties = motionProperties(id = "box")

        Box(
            modifier = Modifier
                .layoutId("box")
                .background(Color(0xFF4CC48E))
        )

        Image(
            modifier = Modifier
                .layoutId("help_image"),
            painter = painterResource(id = R.drawable.help),
            contentDescription = ""
        )

        Icon(
            modifier = Modifier.layoutId("close_button"),
            imageVector = Icons.Filled.Close,
            contentDescription = "",
            tint = Color.White
        )

        Text(
            modifier = Modifier.layoutId("title"),
            text = "Help",
            color = Color.White,
            fontSize = 16.sp
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    CollapsingToolbar()
}

