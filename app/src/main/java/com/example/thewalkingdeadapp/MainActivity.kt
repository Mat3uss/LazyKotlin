package com.example.thewalkingdeadapp

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thewalkingdeadapp.ui.theme.TheWalkingDeadAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheWalkingDeadAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    Image(
        painter = painterResource(id = R.drawable.negan),
        contentDescription = "Background do App",
        contentScale = ContentScale.Crop
    )
    Surface(
        color = Color(0x22aaaaaa)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            OutlinedTextField(value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Buscar Personagens",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(12.dp),
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Botao Buscar",
                            tint = Color.White
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Personagens",
                fontWeight = FontWeight.Bold,
                color = Color(0xffffffff),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(){
                items(20){
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(bottom = 8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xaaaaaaaa)),
                        border = BorderStroke(
                            width = 8.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF4E4E63),
                                    Color(0xFF0D0D0E)
                                ))
                        )
                    ) {
                            Row {
                                Card (
                                    modifier = Modifier
                                        .width(100.dp)
                                        .size(
                                            width = 90.dp,
                                            height = 90.dp
                                        ),
                                    shape = CircleShape
                                ){
                                    Image(contentScale = ContentScale.Crop,
                                        painter = painterResource(id = R.drawable.maggie),
                                        contentDescription = "Maggie TWD",
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .size(width = 100.dp, height = 100.dp)
                                    )
                                }
                                Column {
                                    Text(
                                        text = "Maggie",
                                        fontSize = 26.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,
                                        lineHeight = 15.sp
                                    )
                                    Text(text = "Maggie Greene é uma personagem fictícia da série de quadrinhos The Walking Dead, interpretada por Lauren Cohan na adaptação televisiva de mesmo nome. Na série de quadrinhos, Maggie se torna a mãe substituta de Sophia após o suicídio da mãe da menina")
                                }
                            }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TheWalkingDeadAppTheme {
        Greeting()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            Greeting()
        }
    }
}