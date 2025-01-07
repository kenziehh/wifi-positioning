package com.gelitik.wifi.features.wifi.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gelitik.wifi.features.wifi.domain.model.WifiAccessPoint
import com.gelitik.wifi.features.wifi.domain.usecase.GetWifiNetworksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WifiViewModel @Inject constructor(
    private val getWifiNetworksUseCase: GetWifiNetworksUseCase
) : ViewModel() {

    private val _accessPoints = MutableStateFlow<List<WifiAccessPoint>>(emptyList())
    val accessPoints: StateFlow<List<WifiAccessPoint>> = _accessPoints

    fun fetchWifiNetworks() {
        viewModelScope.launch {
            try {
                val networks = getWifiNetworksUseCase()
                _accessPoints.value = networks
                Log.d("wifi",_accessPoints.value.toString())
            } catch (e: Exception) {
                Log.e("WifiViewModel", "Error fetching Wi-Fi networks", e)
            }
        }
    }
}
