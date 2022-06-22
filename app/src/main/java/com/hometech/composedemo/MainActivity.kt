@file:OptIn(ExperimentalComposeUiApi::class)

package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hometech.composedemo.ui.InputField
import com.hometech.composedemo.ui.theme.ComposeDemoTheme
import com.hometech.composedemo.ui.theme.Purple100
import com.hometech.composedemo.ui.theme.Purple200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
//                TopHeader()
                MainContent()
            }
        }
    }

    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        ComposeDemoTheme {
            Surface {
                content()
            }
        }
    }


    //    @Preview
    @Composable
    fun TopHeader(totalPerPerson: Double = 0.00) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(shape = RoundedCornerShape(12.dp)),
            color = Purple100
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val total = "%.2f".format(totalPerPerson)

                Text(
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    text = "Total Per Person"
                )

                Text(fontWeight = FontWeight.ExtraBold, fontSize = 40.sp, text = "$$total")

            }

        }

    }


    @Preview
    @Composable
    private fun MainContent() {
        val totalBillState = remember {
            mutableStateOf("")
        }

        val validState = remember(totalBillState) {
            totalBillState.value.trim().isNotEmpty()
        }

        val keyBoardController = LocalSoftwareKeyboardController.current

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Column() {
                InputField(
                    valueState = totalBillState,
                    labelId = "Enter Bill",
                    enabled = true,
                    isSingleLine = true,
                    onAction = KeyboardActions {

                        if (!validState) return@KeyboardActions
                        //Todo -> OnValueChanged

                        keyBoardController?.hide()
                    }
                )


            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyApp {
        }
    }


}