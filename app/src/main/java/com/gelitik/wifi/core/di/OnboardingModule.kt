package com.gelitik.wifi.core.di

import android.app.Application
import android.speech.tts.TextToSpeech
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object OnboardingModule {

    @Provides
    @ViewModelScoped
    fun provideTextToSpeech(application: Application): TextToSpeech {
        lateinit var tts: TextToSpeech
        tts = TextToSpeech(application) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale("id", "ID") // Pakai referensi eksplisit ke `tts`
            }
        }
        return tts
    }
}
