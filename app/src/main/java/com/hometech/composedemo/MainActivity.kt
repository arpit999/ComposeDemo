package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.hometech.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {

            }
        }
    }

    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        ComposeDemoTheme {
            content()
        }
    }

}

