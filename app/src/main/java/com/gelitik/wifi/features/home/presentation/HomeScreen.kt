package com.gelitik.wifi.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gelitik.wifi.R
import com.gelitik.wifi.presentation.theme.PrimaryGreen

@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().safeDrawingPadding().padding(20.dp)) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Row{
                    Image(
                        painter = painterResource(R.drawable.pin),
                        contentDescription = "pin",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("Pilih Gedung", style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    ))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.Center) {
                    Text("Sesuaikan dengan kebutuhanmu!", style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                    )
                }
            }
            Image(painter = painterResource(R.drawable.filkom), contentDescription = "", modifier = Modifier.size(160.dp)

            )
            Button(onClick = {
                navController.navigate("map") {
                    popUpTo("map") { inclusive = true }
                }            }, modifier = Modifier.padding(8.dp).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen)
            ) { Text("Lanjut", style = TextStyle(
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )) }
        }


    }
}