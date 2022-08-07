package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.hometech.composedemo.ui.theme.ComposeDemoTheme
import com.hometech.composedemo.ui.theme.Dimens
import kotlin.math.roundToInt

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(modifier = Modifier) {
                CollapsingToolbarBase(toolbarHeading = "Help", toolbarHeight = 200.dp, toolbarOffset = 150.00f) {

                }


            }

        }
    }
}


/**
 * Collapsing Toolbar that can be used in a topBar slot of Scaffold.
 * It has a back button, default bottom rounded corners
 * & a box scope which holds content centered by default.
 * You need to implement nestedScrollConnection to set the offset values
 * See Usage of this in AboutScreen or SettingsScreen or DetailsScreen
 *
 * To use this Toolbar with a persistent Image that's always visible
 * and just shrinks when scroll then leave the toolbarHeading blank("")
 *
 * With nestedScrollConnection know that the maximum offset that can be
 * reached is -132.0
 */
@Composable
fun CollapsingToolbarBase(
    modifier: Modifier = Modifier,
    toolbarHeading: String,
    onBackButtonPressed: () -> Unit = { },
    contentAlignment: Alignment = Alignment.Center,
    shape: Shape = RoundedCornerShape(
        bottomEnd = 10.dp,
        bottomStart = 10.dp
    ),
    collapsedBackgroundColor: Color = MaterialTheme.colors.onSecondary,
    backgroundColor: Color = MaterialTheme.colors.background,
    toolbarHeight: Dp=150.dp,
    minShrinkHeight: Dp = 50.dp,
    toolbarOffset: Float,
    content: @Composable BoxScope.() -> Unit
) {
    //Scale animation
    val animatedProgress = remember {
        Animatable(initialValue = 0.9f)
    }

    val scrollDp = toolbarHeight + toolbarOffset.dp
    val animatedCardSize by animateDpAsState(
        targetValue = if (scrollDp <= minShrinkHeight) minShrinkHeight else scrollDp,
        animationSpec = tween(300, easing = LinearOutSlowInEasing)
    )
    val animatedElevation by animateDpAsState(
        targetValue = if (scrollDp < minShrinkHeight + 20.dp) 10.dp else 0.dp,
        animationSpec = tween(500, easing = LinearOutSlowInEasing)
    )
    val animatedTitleAlpha by animateFloatAsState(
        targetValue = if (toolbarHeading.isNotBlank()) {
            if (scrollDp <= minShrinkHeight + 20.dp) 1f else 0f
        } else 0f,
        animationSpec = tween(300, easing = LinearOutSlowInEasing)
    )
    val animatedColor by animateColorAsState(
        targetValue = if (scrollDp < minShrinkHeight + 20.dp) collapsedBackgroundColor
        else backgroundColor,
        animationSpec = tween(300, easing = LinearOutSlowInEasing)
    )

    LaunchedEffect(key1 = animatedProgress) {
        animatedProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(500, easing = FastOutSlowInEasing)
        )
    }

    val animatedModifier = modifier
        .graphicsLayer(
            scaleX = animatedProgress.value
        )

    Box(
        modifier = animatedModifier
            .fillMaxWidth()
            .height(animatedCardSize)
            .shadow(
                elevation = animatedElevation,
                shape = shape
            )
            .background(
                color = animatedColor,
                shape = shape
            )
    ) {
        Row(
            modifier = Modifier
                .statusBarsPadding(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackButtonPressed,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back Button",
                    tint = MaterialTheme.colors.onBackground
                )
            }
            Text(
                text = toolbarHeading,
                color = MaterialTheme.colors.onPrimary.copy(
                    alpha = animatedTitleAlpha
                ),
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .alpha(1 - animatedTitleAlpha),
            contentAlignment = contentAlignment,
            content = content
        )
    }
}

@Preview
@Composable
fun CollapsingToolbarBasePrev() {
    ComposeDemoTheme() {
        Column {
            CollapsingToolbarBase(
                toolbarHeading = "Settings",
                toolbarOffset = -100f,
                toolbarHeight = 50.dp,
                content = {
                    Text(
                        text = "Settings",
                        color = MaterialTheme.colors.onSecondary,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier
                            .padding(horizontal = Dimens.SmallPadding.size)
                            .animateContentSize(
                                animationSpec = tween(
                                    300,
                                    easing = LinearOutSlowInEasing
                                )
                            )
                    )
                }
            )

            LazyColumn {
                // Add a single item
                item {
                    Text(modifier = Modifier.padding(24.dp), text = "First item")
                }

                // Add 5 items
                items(50) { index ->
                    Text(modifier = Modifier.padding(24.dp), text = "Item: $index")
                }

                // Add another single item
                item {
                    Text(modifier = Modifier.padding(24.dp), text = "Last item")
                }
            }
        }
    }
}


@Preview
@Composable
fun ToolbarTest() {
    // here we use LazyColumn that has build-in nested scroll, but we want to act like a
// parent for this LazyColumn and participate in its nested scroll.
// Let's make a collapsing toolbar for LazyColumn
    val toolbarHeight = 48.dp
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }
// our offset to collapse toolbar
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
// now, let's create connection to the nested scroll system and listen to the scroll
// happening inside child LazyColumn
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // try to consume before LazyColumn to collapse toolbar if needed, hence pre-scroll
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
                // here's the catch: let's pretend we consumed 0 in any case, since we want
                // LazyColumn to scroll anyway for good UX
                // We're basically watching scroll without taking it
//                Timber.d("offset value; ${toolbarOffsetHeightPx.value}")
                return Offset.Zero
            }
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            // attach as a parent to the nested scroll system
            .nestedScroll(nestedScrollConnection)
    ) {
        // our list with build in nested scroll support that will notify us about its scroll
        LazyColumn(
            contentPadding = PaddingValues(top = toolbarHeight),
            modifier = Modifier
        ) {
            items(100) { index ->
                Text(
                    "I'm item $index", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
        TopAppBar(
            modifier = Modifier
                .height(toolbarHeight)
                .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
            title = { Text("toolbar offset is ${toolbarOffsetHeightPx.value}") }
        )
    }
}

@Composable
fun CollapsingEffectScreen() {
    val items = (1..100).map { "Item $it" }
    val lazyListState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0

    Column {
        //for fix toolbar on top
        Surface {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(color = MaterialTheme.colors.onSecondary)
            ) {

            }
        }
        LazyColumn(
            Modifier.fillMaxSize(),
            lazyListState,
        ) {

            item {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .graphicsLayer {
                            scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                            translationY = scrolledY * 0.5f
                            previousOffset = lazyListState.firstVisibleItemScrollOffset
                        }
                        .height(220.dp)
                        .fillMaxWidth()
                )
            }
            items(items) {
                Text(
                    text = it,
                    Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CollapsingEffectScreen()
//        CollapsingToolbarBasePrev()

}

