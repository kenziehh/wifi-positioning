package com.gelitik.wifi.features.onboarding.presentation

import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val textToSpeech: TextToSpeech
) : ViewModel() {

    private val _isSpeechFinished = MutableStateFlow(false)
    val isSpeechFinished: StateFlow<Boolean> = _isSpeechFinished

    init {
        setupTextToSpeechListener()
    }

    private fun setupTextToSpeechListener() {
        textToSpeech.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {}

            override fun onDone(utteranceId: String?) {
                viewModelScope.launch {
                    _isSpeechFinished.emit(true)
                }
            }

            override fun onError(utteranceId: String?) {}
        })
    }

    fun speak(text: String) {
        viewModelScope.launch {
            _isSpeechFinished.emit(false)
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "OnboardingSpeech")
        }
    }

    override fun onCleared() {
        super.onCleared()
        textToSpeech.stop()
        textToSpeech.shutdown()
    }
}

