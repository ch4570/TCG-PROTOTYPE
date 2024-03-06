package com.splab.backend.homework.member.service

import com.splab.backend.homework.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RemoveMemberService(
    private val memberRepository: MemberRepository
) : RemoveMemberUseCase {
    override fun removeMember(memberId: Long) {
        memberRepository.deleteById(memberId)
    }
}