package com.splab.backend.homework.member.service

import com.splab.backend.homework.member.dto.response.MemberResponse
import com.splab.backend.homework.member.entity.Level

interface LoadMemberUseCase {

    fun loadMemberListByCondition(name: String?, level: Level?) : List<MemberResponse>
}