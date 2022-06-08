package com.hometech.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    @Composable
    fun MyApp() {

        val moneyCounter = remember {
            mutableStateOf(0)
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xFF546E7A)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "$${moneyCounter.value}",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 35.sp
                    )
                )

                Spacer(modifier = Modifier.height(200.dp))
                CreateCircle(moneyCounter = moneyCounter.value) { newValue ->
                    moneyCounter.value = newValue
                }
            }

        }
    }


    //    @Preview
    @Composable
    fun CreateCircle(moneyCounter: Int = 0, updateMoneyCounter: (Int) -> Unit) {
        Card(
            modifier = Modifier
                .padding(3.dp)
                .size(90.dp),
            shape = CircleShape, elevation = 8.dp
        ) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier.clickable {
                    updateMoneyCounter(moneyCounter + 1)
                }
            ) {

                Text(text = "TAP $moneyCounter")
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