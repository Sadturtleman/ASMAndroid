package com.afternote.asmandroid.domain.repository

import com.afternote.asmandroid.domain.entity.IntroEntity

interface IntroRepository {
    suspend fun getIntro(): IntroEntity
}
