package com.gelitik.wifi


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import com.gelitik.wifi.presentation.theme.Wifi_positionngTheme
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.net.wifi.ScanResult
import android.util.Log
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gelitik.wifi.features.home.presentation.HomeScreen
import com.gelitik.wifi.features.home.presentation.MapScreen
import com.gelitik.wifi.features.onboarding.presentation.OnboardingScreen
import com.gelitik.wifi.features.onboarding.presentation.SplashScreen
import com.gelitik.wifi.features.wifi.presentation.screen.WifiScannerScreen
import com.gelitik.wifi.presentation.theme.PrimaryBlack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Wifi_positionngTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = PrimaryBlack
                ) {
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen(navController=navController)
                        }
                        composable("onboarding") {
                            OnboardingScreen(navController = navController)
                        }
                        composable("home") {
                            HomeScreen(navController = navController)
                        }
                        composable("map") {
                            MapScreen()
                        }
                    }
                }
            }
        }
    }
}
