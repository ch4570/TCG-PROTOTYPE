package com.splab.backend.homework.member.service

import com.splab.backend.homework.member.entity.Level
import com.splab.backend.homework.member.entity.Member
import com.splab.backend.homework.member.repository.MemberQueryRepository
import com.splab.backend.homework.member.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class LoadMemberService(
    private val memberQueryRepository: MemberQueryRepository,
    private val memberRepository: MemberRepository
) : LoadMemberUseCase{
    override fun loadMemberListByCondition(name: String?, level: Level?) =
        memberQueryRepository.loadMemberListByCondition(name, level)

    override fun loadMemberById(memberId: Long) =
        memberRepository.findByIdOrNull(memberId)
}