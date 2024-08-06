package com.example.business_my_card_app

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_my_card_app.ui.theme.BusinessmycardappTheme
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.zIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessmycardappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF808080)
                ) {
                    GreetingWithImageAndText(
                        name = "Matheus Bento Vieira",
                        description = "Android Developer",
                        contactEmail = "\uD83D\uDCE9  matheusbentov404@gmail.com",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}


@Composable
fun GreetingWithImageAndText(name: String, contactEmail: String, description: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        // Texto, que fica por baixo da imagem
        GreetingText(name = name, contactEmail = contactEmail, description = description, modifier = Modifier.fillMaxSize())

        // Imagem, que fica por cima do texto
        GreetingImage(modifier = Modifier
            .align(Alignment.TopCenter)
            .width(200.dp) // Ajusta largura da imagem
            .offset(y = 300.dp) // Ajusta a posição da imagem para que fique mais próxima ao texto
            .zIndex(1f) // Garante que a imagem fique acima do texto
        )
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Image(
        painter = image,
        contentScale = ContentScale.Fit,
        contentDescription = "Android logo",
        modifier = modifier
            .background(Color(0xFF001F3F))
            .size(150.dp) // Define o tamanho da imagem
    )
}


    @Composable
    fun GreetingText(name: String, contactEmail: String, description: String, modifier: Modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(top = 80.dp) // Ajusta a posição do texto para que não fique atrás da imagem
        ) {
            Text(
                text = name,
                fontSize = 35.sp,
                fontFamily = FontFamily.Serif,           //ajustar fonte do texto
                fontWeight = FontWeight.Light,           //ajustar peso da fonte
                lineHeight = 60.sp // Ajuste para que o texto não sobreponha
            )
            Text(
                text = description,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF3ddc84),
                textAlign = TextAlign.Center
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(top = 700.dp)
        ){
            Text(
                text = contactEmail,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
        }
    }
