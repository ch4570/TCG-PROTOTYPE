package com.splab.backend.homework.member.repository

import com.splab.backend.homework.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {

    fun findByMemberEmail(email: String) : Member?
}