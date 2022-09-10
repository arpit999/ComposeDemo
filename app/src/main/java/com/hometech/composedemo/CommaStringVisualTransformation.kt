package com.hometech.composedemo

import android.util.Log
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.core.text.isDigitsOnly
import java.util.*

class CommaStringVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {

        val inputString =
            if (text.text.isDigitsOnly() && text.text.isNotEmpty() && isLanguageEnglish()) {
                "$ " + String.format("%,d", text.text.toLong())
            } else if (text.text.isDigitsOnly() && text.text.isNotEmpty() && !isLanguageEnglish()) {
                String.format("%,d", text.text.toLong()) + " $"
            } else {
                text
            }

        Log.d("filter", "inputString: $inputString")

        val offsetMapping = object : OffsetMapping {
            val initSize = 0
            override fun originalToTransformed(offset: Int): Int {

                val commasOrSpace = inputString.count { (it == ',') || (it == ' ') }
                val dollar = inputString.count { it == '$' }
//                val space = commaString.count { it == ' ' }

                var total =
                    if (isLanguageEnglish()) offset + commasOrSpace + dollar else offset + commasOrSpace  - 1

                if (!isLanguageEnglish()) {
                    if (offset in 4..6) total += 1
                    if (offset in 7..9) total += 2
                    if (offset in 10..12) total += 3
                    if (offset in 13..15) total += 4
                }
                Log.d(
                    "originalToTransformed",
                    "Offset: $offset, Commas/Spaces: $commasOrSpace, Dollar: $dollar, Total: $total"
                )
                return if (offset == 0) initSize else total
            }

            override fun transformedToOriginal(offset: Int): Int {
                Log.d("Offset", "transformedToOriginal: $offset")
                val commas = inputString.count { it == ',' }
                val dollar = inputString.count { it == '$' }
                val space = inputString.count { it == ' ' }

                val total = offset + commas + dollar + space

                Log.d(
                    "transformedToOriginal",
                    "Offset: $offset, Commas: $commas, Dollar: $dollar, Space: $space, Total: $total"
                )

                return total
            }
        }

        return TransformedText(
            text = AnnotatedString("$inputString"),
            offsetMapping = offsetMapping
        )
    }

    fun isLanguageEnglish(): Boolean {
        val currentLanguage = Locale.getDefault().language
        return currentLanguage.equals("en")
    }

}