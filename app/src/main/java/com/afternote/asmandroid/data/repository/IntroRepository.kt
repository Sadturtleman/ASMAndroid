package com.afternote.asmandroid.data.repository

import com.afternote.asmandroid.data.api.IntroResponse

interface IntroRepository {
    suspend fun getIntro(): IntroResponse
}
