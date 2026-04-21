package com.afternote.asmandroid.data.api

import com.afternote.asmandroid.data.api.dto.IntroResponseDto
import retrofit2.http.GET

interface IntroApiService {
    @GET("api/v1/intro")
    suspend fun getIntro(): IntroResponseDto
}
