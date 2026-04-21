package com.afternote.asmandroid.data.repository

import com.afternote.asmandroid.data.api.IntroApiService
import com.afternote.asmandroid.data.api.IntroResponse
import javax.inject.Inject

class IntroRepositoryImpl @Inject constructor(
    private val apiService: IntroApiService
) : IntroRepository {
    override suspend fun getIntro(): IntroResponse = apiService.getIntro()
}
