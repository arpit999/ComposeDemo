package com.hometech.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.hometech.composedemo.ui.ExpandableCard
import com.hometech.composedemo.ui.QuestionDb
import com.hometech.composedemo.ui.theme.ComposeDemoTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeDemoTheme() {

                var questions by remember {
                    mutableStateOf(QuestionDb.getQuestions())
                }

                LazyColumn {
                    items(questions) { item: Question ->
                        ExpandableCard(
                            item = item,
                            onExpanded = { clickedItem ->
                                val updatedItem = clickedItem.copy(expanded = clickedItem.expanded.not())
                                questions =
                                    questions.updateItem(updatedItem) { it.questionText == clickedItem.questionText }
                            }
                        )
                    }
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}

fun parent() {

    child(onChildClickA = {
        // click handle
    }, onChildClickB = {

    })
}

fun child(onChildClickA: () -> Unit, onChildClickB: () -> Unit) {
    // compose code
    // click
    onChildClickA.invoke()
    //onChildClick()
}

