package com.gelitik.wifi.features.wifi.domain.model

data class WifiAccessPoint(
    val ssid: String,
    val bssid: String,
    val signalStrength: Int,
    val frequency: Int,
    val capabilities: String
)