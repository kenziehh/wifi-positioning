package com.gelitik.wifi.core.di

import android.content.Context
import com.gelitik.wifi.features.wifi.data.repository.WifiRepositoryImpl
import com.gelitik.wifi.features.wifi.domain.repository.WifiRepository
import com.gelitik.wifi.features.wifi.domain.usecase.GetWifiNetworksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WifiModule {

    @Singleton
    @Provides
    fun provideWifiRepository(
        @ApplicationContext context: Context
    ): WifiRepository {
        return WifiRepositoryImpl(context)
    }

    @Singleton
    @Provides
    fun provideGetWifiNetworksUseCase(
        repository: WifiRepository
    ): GetWifiNetworksUseCase {
        return GetWifiNetworksUseCase(repository)
    }
}
