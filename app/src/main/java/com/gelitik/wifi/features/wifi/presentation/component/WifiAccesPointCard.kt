package com.gelitik.wifi.features.wifi.presentation.component

import android.net.wifi.ScanResult
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gelitik.wifi.features.wifi.domain.model.WifiAccessPoint

@Composable
fun WifiAccessPointCard(ap: WifiAccessPoint) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = ap.ssid.ifEmpty { "<Hidden SSID>" },
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "BSSID: ${ap.bssid}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Signal Strength: ${ap.signalStrength} dBm",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Frequency: ${ap.frequency} MHz",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Security: ${ap.capabilities}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}