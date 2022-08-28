package com.hometech.composedemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hometech.composedemo.navigation.BookAppNavigation
import com.hometech.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                BookAppNavigation()
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        ComposeDemoTheme {
            content.invoke()
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MyApp {
            BookAppNavigation()
        }
    }

}

