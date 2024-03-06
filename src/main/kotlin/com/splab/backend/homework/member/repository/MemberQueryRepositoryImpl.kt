package com.splab.backend.homework.member.repository

import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import com.splab.backend.homework.member.dto.response.MemberResponse
import com.splab.backend.homework.member.entity.Level
import com.splab.backend.homework.member.entity.QMember.*
import org.springframework.stereotype.Repository

@Repository
class MemberQueryRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : MemberQueryRepository {
    override fun loadMemberListByCondition(name: String?, level: Level?) : List<MemberResponse> {
        return jpaQueryFactory.select(
            Projections.constructor(
                MemberResponse::class.java,
                member.memberId,
                member.memberName,
                member.memberEmail,
                member.regDate,
                member.level,
                member.cardCount
            )).from(member)
            .where(levelEq(level), nameEq(name))
            .fetch()
    }

    private fun levelEq(level: Level?) =
        if (level != null) member.level.eq(level) else null

    private fun nameEq(name: String?) =
        if (!name.isNullOrBlank()) member.memberName.contains(name) else null
}