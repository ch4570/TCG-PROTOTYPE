package com.splab.backend.homework.member.entity

import com.splab.backend.homework.common.entity.BaseTimeEntity
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Member(
    @Id
    @Column(name = "MEMBER_ID", columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberId: Long? = null,

    @Column(name = "MEMBER_NAME", columnDefinition = "VARCHAR(100)")
    val memberName: String,

    @Column(name = "MEMBER_EMAIL", columnDefinition = "VARCHAR(50)")
    val memberEmail: String,

    @Column(name = "MEMBER_CARD_COUNT", columnDefinition = "INT")
    val cardCount: Int,

    @Column(name = "MEMBER_CARD_TOTAL_PRICE", columnDefinition = "INT")
    val cardTotalPrice: Double,

    @Column(name = "MEMBER_LEVEL", columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    val level: Level,

    @Column(name = "MEMBER_REG_DATE", columnDefinition = "TIMESTAMP")
    val regDate: LocalDate
) : BaseTimeEntity()