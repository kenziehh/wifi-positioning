package com.gelitik.wifi.features.wifi.domain.usecase

import com.gelitik.wifi.features.wifi.domain.repository.WifiRepository

class GetWifiNetworksUseCase(private val repository: WifiRepository) {
    suspend operator fun invoke() = repository.getWifiNetworks()
}