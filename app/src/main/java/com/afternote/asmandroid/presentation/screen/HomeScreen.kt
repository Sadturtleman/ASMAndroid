package com.afternote.asmandroid.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.afternote.asmandroid.domain.entity.IntroEntity
import com.afternote.asmandroid.presentation.viewmodel.HomeUiState
import com.afternote.asmandroid.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeScreenContent(modifier = modifier, uiState = uiState)
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        when (val state = uiState) {
            is HomeUiState.Loading -> {
                CircularProgressIndicator()
            }

            is HomeUiState.Error -> {
                Text(
                    text = "Error: ${state.message}",
                    color = MaterialTheme.colorScheme.error,
                )
            }

            is HomeUiState.Success -> {
                IntroContent(state.data)
            }
        }
    }
}

@Composable
private fun IntroContent(entity: IntroEntity) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(24.dp),
    ) {
        Text(
            text = entity.debugTestMessage,
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "최소 앱 버전: ${entity.minAppVersion}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "권장 앱 버전: ${entity.recommendAppVersion}")
    }
}
