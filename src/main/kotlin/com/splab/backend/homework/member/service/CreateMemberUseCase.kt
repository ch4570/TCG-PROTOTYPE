package com.splab.backend.homework.member.service

import com.splab.backend.homework.member.dto.request.CreateMemberCommand

interface CreateMemberUseCase {

    fun createMember(memberCommand: CreateMemberCommand)
}