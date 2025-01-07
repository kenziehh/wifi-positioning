package com.gelitik.wifi.features.wifi.data.repository

import android.net.wifi.WifiManager
import com.gelitik.wifi.features.wifi.domain.model.WifiAccessPoint
import com.gelitik.wifi.features.wifi.domain.repository.WifiRepository
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat


class WifiRepositoryImpl(private val context: Context) : WifiRepository {
    override suspend fun getWifiNetworks(): List<WifiAccessPoint> {
        val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager

        var requiredPermissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            requiredPermissions += Manifest.permission.NEARBY_WIFI_DEVICES
        }

        val missingPermissions = requiredPermissions.filter {
            ActivityCompat.checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED
        }

        if (missingPermissions.isNotEmpty()) {
            throw SecurityException("Missing required permissions: $missingPermissions")
        }

        try {
            if (!wifiManager.isWifiEnabled) {
                wifiManager.isWifiEnabled = true
            }

            return wifiManager.scanResults.map {
                WifiAccessPoint(
                    ssid = it.SSID.ifEmpty { "<Hidden SSID>" },
                    bssid = it.BSSID,
                    signalStrength = it.level,
                    frequency = it.frequency,
                    capabilities = it.capabilities
                )
            }
        } catch (e: SecurityException) {
            Log.e("error","wifi error",e)
            throw e
        }
    }
}