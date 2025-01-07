package com.gelitik.wifi.features.wifi.presentation.screen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.gelitik.wifi.features.wifi.presentation.component.WifiAccessPointCard
import com.gelitik.wifi.features.wifi.presentation.viewmodel.WifiViewModel

@Composable
fun WifiScannerScreen(viewModel: WifiViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val accessPoints by viewModel.accessPoints.collectAsState()
    val hasPermissions = remember { mutableStateOf(checkPermissions(context)) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                if (hasPermissions.value) {
                    viewModel.fetchWifiNetworks()
                } else {
                    requestPermissions(context)
                    hasPermissions.value = checkPermissions(context)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(if (hasPermissions.value) "Scan WiFi Networks" else "Request Permissions")
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(accessPoints) { result ->
                WifiAccessPointCard(result)
            }
        }
    }
}


private fun requestPermissions(context: Context) {
    ActivityCompat.requestPermissions(
        context as androidx.activity.ComponentActivity,
        arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.NEARBY_WIFI_DEVICES
        ),
        1
    )
}

private fun checkPermissions(context: Context): Boolean {
    return arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.NEARBY_WIFI_DEVICES
    ).all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }
}
