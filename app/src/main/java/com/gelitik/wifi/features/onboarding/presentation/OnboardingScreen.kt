package com.gelitik.wifi.features.onboarding.presentation

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gelitik.wifi.R
import com.gelitik.wifi.presentation.theme.PrimaryGreen
import kotlinx.coroutines.delay

@Composable
fun OnboardingScreen(
    navController: NavController,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val textTitle = "Revolusi Navigasi"
    val textDescription =
        "InMove menggunakan sinyal Wi-Fi di sekitarmu untuk menentukan lokasi dan memberikan petunjuk arah. " +
                "Pastikan kamu mengaktifkan izin lokasi untuk mendapatkan pengalaman navigasi terbaik."

    val isSpeechFinished by viewModel.isSpeechFinished.collectAsState()

    LaunchedEffect(Unit) {
        delay(2000)
        viewModel.speak(textDescription)
    }

    LaunchedEffect(isSpeechFinished) {
        if (isSpeechFinished) {
            navController.navigate("home") {
                popUpTo("onboarding") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboard),
            contentDescription = "Ilustrasi Navigasi",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = textTitle,
            color = PrimaryGreen,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = textDescription,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center

        )
    }
}

