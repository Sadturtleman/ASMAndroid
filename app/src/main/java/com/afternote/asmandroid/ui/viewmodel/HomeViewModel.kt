package com.afternote.asmandroid.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afternote.asmandroid.data.api.IntroResponse
import com.afternote.asmandroid.data.repository.IntroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Success(
        val data: IntroResponse,
    ) : HomeUiState

    data class Error(
        val message: String,
    ) : HomeUiState
}

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val introRepository: IntroRepository,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
        val uiState: StateFlow<HomeUiState> = _uiState

        init {
            fetchIntro()
        }

        private fun fetchIntro() {
            viewModelScope.launch {
                _uiState.value = HomeUiState.Loading
                runCatching { introRepository.getIntro() }
                    .onSuccess { _uiState.value = HomeUiState.Success(it) }
                    .onFailure { _uiState.value = HomeUiState.Error(it.message ?: "Unknown error") }
            }
        }
    }
