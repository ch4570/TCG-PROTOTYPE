package com.splab.backend.homework.member.repository

import com.splab.backend.homework.member.dto.response.MemberResponse
import com.splab.backend.homework.member.entity.Level

interface MemberQueryRepository {

    fun loadMemberListByCondition(name: String?, level: Level?) : List<MemberResponse>
}