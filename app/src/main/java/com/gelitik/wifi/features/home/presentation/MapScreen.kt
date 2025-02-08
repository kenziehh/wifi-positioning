package com.gelitik.wifi.features.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gelitik.wifi.R
import com.gelitik.wifi.presentation.theme.PrimaryBlack
import com.gelitik.wifi.presentation.theme.PrimaryGreen

@Composable
fun MapScreen(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.map), 
            contentDescription = "Map Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Search Bar
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                color = PrimaryGreen
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = PrimaryBlack
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Masukkan tujuan Anda",
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp),
                        color = PrimaryBlack,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        FloatingActionButton(
            onClick = { /* TODO */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = PrimaryGreen,
            contentColor = Color.Black
        ) {
            Image(painter = painterResource(R.drawable.mic), contentDescription = "")
        }
    }
}