package com.splab.backend.homework.member.dto.response

import com.splab.backend.homework.member.entity.Level
import java.time.LocalDate

data class MemberResponse(
    val id: Long,
    val name: String,
    val email: String,
    val regDate: LocalDate,
    val level: Level,
    val cardCount: Int
)