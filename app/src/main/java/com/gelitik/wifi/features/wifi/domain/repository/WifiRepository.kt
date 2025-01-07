package com.gelitik.wifi.features.wifi.domain.repository

import com.gelitik.wifi.features.wifi.domain.model.WifiAccessPoint

interface WifiRepository {
    suspend fun getWifiNetworks(): List<WifiAccessPoint>
}