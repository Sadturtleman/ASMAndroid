package com.afternote.asmandroid.data.mapper

import com.afternote.asmandroid.data.api.dto.IntroResponseDto
import com.afternote.asmandroid.domain.entity.IntroEntity

fun IntroResponseDto.toEntity(): IntroEntity =
    IntroEntity(
        minAppVersion = minAppVersion,
        recommendAppVersion = recommendAppVersion,
        debugTestMessage = debugTestMessage,
    )
