package com.splab.backend.homework.member.service

import com.splab.backend.homework.member.dto.response.MemberResponse
import com.splab.backend.homework.member.entity.Level
import com.splab.backend.homework.member.entity.Member

interface LoadMemberUseCase {

    fun loadMemberListByCondition(name: String?, level: Level?) : List<MemberResponse>

    fun loadMemberById(memberId: Long) : Member?
}