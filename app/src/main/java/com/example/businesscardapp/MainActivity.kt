package com.example.businesscardapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    BusinessCardText(
                        message = "Henna Artistry",
                        from="Fatima Mansha \nEmail: fatimamansha@outlook.com",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}
@Composable
fun BusinessCardText(message: String,
                     from: String,
                     modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(horizontal = 60.dp, vertical=160.dp)
    ){
        Text(
            text = message,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(

            text = from,
            color = Color.Black,
            fontSize = 15.sp,
            textAlign= TextAlign.Center

        )
    }
}

@Composable
fun BusinessCardImage(message: String, from: String, modifier: Modifier = Modifier){
    val image= painterResource(R.drawable.mehndi_horizontal)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.7F,
            modifier = Modifier.size(500.dp)
        )
        BusinessCardText(
            message=message,
            from = from,
            modifier= Modifier.padding(2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCard() {

    BusinessCardAppTheme {

        BusinessCardImage("Henna Artistry", from = "Fatima Mansha \nEmail: fatimamansha@outlook.com")
    }
    }
