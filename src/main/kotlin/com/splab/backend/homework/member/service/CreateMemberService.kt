package com.splab.backend.homework.member.service

import com.splab.backend.homework.member.dto.request.CreateMemberCommand
import com.splab.backend.homework.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CreateMemberService(
    private val memberRepository: MemberRepository
) : CreateMemberUseCase {

    override fun createMember(memberCommand: CreateMemberCommand) {
        val member = memberCommand.mapToEntity()

        memberRepository.save(member)
    }
}