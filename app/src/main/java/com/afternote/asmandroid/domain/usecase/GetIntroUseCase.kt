package com.afternote.asmandroid.domain.usecase

import com.afternote.asmandroid.domain.entity.IntroEntity
import com.afternote.asmandroid.domain.repository.IntroRepository
import javax.inject.Inject

class GetIntroUseCase
    @Inject
    constructor(
        private val introRepository: IntroRepository,
    ) {
        suspend operator fun invoke(): IntroEntity = introRepository.getIntro()
    }
