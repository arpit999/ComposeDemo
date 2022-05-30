package com.hometech.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hometech.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {

                Surface(color = MaterialTheme.colors.background) {
                    CreateBizCard()
                }
            }
        }
    }


    @Composable
    fun CreateBizCard() {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(390.dp)
                    .padding(12.dp),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)), elevation = 4.dp
            ) {

                Column(
                    modifier = Modifier.height(300.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    CreateImageProfile()
                    Divider(
                        modifier = Modifier.padding(0.dp, 5.dp),
                        Color.LightGray
                    )

                    CreateInfo()

                    Button(
                        modifier = Modifier.padding(3.dp),
                        onClick = { Log.d("Clicked", "CreateBizCard: Clicked") }) {
                        Text(text = "Portfolio", style = MaterialTheme.typography.button)
                    }
                }

            }

        }
    }

    @Composable
    private fun CreateInfo() {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Miles P.",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primaryVariant
            )
            Text(text = "Android Compose Programmer", modifier = Modifier.padding(3.dp))
            Text(
                text = "@theCompose",
                modifier = Modifier.padding(3.dp),
                style = MaterialTheme.typography.subtitle2
            )

        }
    }

    @Composable
    private fun CreateImageProfile() {
        Surface(
            modifier = Modifier
                .size(150.dp)
                .padding(5.dp),
            shape = CircleShape,
            border = BorderStroke(.5.dp, Color.LightGray),
            elevation = 4.dp,
            color = MaterialTheme.colors.surface.copy(alpha = .5f)
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile picture",
                modifier = Modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme {
            CreateBizCard()
        }
    }

}

