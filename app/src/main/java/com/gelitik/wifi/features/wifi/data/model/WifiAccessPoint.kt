package com.gelitik.wifi.features.wifi.data.model

data class WifiAccessPoint(
    val ssid: String,
    val bssid: String,
    val signalStrength: Int,
    val frequency: Int,
    val capabilities: String
)