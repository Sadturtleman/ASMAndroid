package com.afternote.asmandroid.data.repository

import com.afternote.asmandroid.data.api.IntroApiService
import com.afternote.asmandroid.data.mapper.toEntity
import com.afternote.asmandroid.domain.entity.IntroEntity
import com.afternote.asmandroid.domain.repository.IntroRepository
import javax.inject.Inject

class IntroRepositoryImpl
    @Inject
    constructor(
        private val apiService: IntroApiService,
    ) : IntroRepository {
        override suspend fun getIntro(): IntroEntity = apiService.getIntro().toEntity()
    }
