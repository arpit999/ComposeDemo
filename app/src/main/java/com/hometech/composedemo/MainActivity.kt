package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.hometech.composedemo.ui.theme.ComposeDemoTheme
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                var text by remember { mutableStateOf("") }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        modifier = Modifier,
                        value = text,
                        onValueChange = {
                            text = if (it.startsWith(".") || it.startsWith(",") && isLanguageEnglish()) {
                                "0" + it.replace(",", ".")
                            } else if (it.startsWith("0") && !isLanguageEnglish()) {
                                "0" + it.replace(".", ",")
                            } else {
                                getDecimalFormat(it)
                            }.trim().replace("-","").replace(" ","")
                        },
                        visualTransformation = CommaStringVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Decimal
                        ),
                        label = {
                            Column() {
                                Text(text = "Amount")
                            }
                        },
                        singleLine = true
                    )
                }
            }
        }
    }

    private fun getDecimalFormat(amount: String): String {
        return if (isLanguageEnglish()) {
            if (amount.contains(",")) {
                amount.replace(",", ".")
            }
            amount.replace(",", ".")
        } else {
            amount.replace(".", ",")
        }
    }

    private fun isLanguageEnglish(): Boolean {
        val currentLanguage = Locale.getDefault().language
        return currentLanguage.equals("en")
    }


    private fun getCurrency(text: String): String {
        val systemLanguage = Locale.getDefault().language

        val canadianFormat: NumberFormat =
            if (systemLanguage.equals("en")) NumberFormat.getCurrencyInstance(Locale.CANADA) else NumberFormat.getCurrencyInstance(
                Locale.CANADA_FRENCH
            )
        return canadianFormat.format(text)
    }

    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        ComposeDemoTheme {
            content.invoke()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyApp {
            OutlinedTextField(modifier = Modifier, value = "", onValueChange = {
                val systemLanguage = Locale.getDefault().language

                val canadianFormat: NumberFormat =
                    if (systemLanguage.equals("en")) NumberFormat.getCurrencyInstance(Locale.CANADA) else NumberFormat.getCurrencyInstance(
                        Locale.CANADA_FRENCH
                    )
                val amount = BigDecimal(it).toString()
            })
        }
    }

}

