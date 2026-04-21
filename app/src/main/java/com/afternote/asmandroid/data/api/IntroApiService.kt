package com.afternote.asmandroid.data.api

import retrofit2.http.GET

interface IntroApiService {
    @GET("api/v1/intro")
    suspend fun getIntro(): IntroResponse
}
