package com.splab.backend.homework.member.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Member(
    @Id
    @Column(name = "MEMBER_ID", columnDefinition = "INT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberId: Long? = null,

    @Column(name = "MEMBER_NAME", columnDefinition = "VARCHAR(120)")
    val name: String,

    @Column(name = "MEMBER_EMAIL", columnDefinition = "VARCHAR(50)")
    val email: String,

    @Column(name = "MEMBER_CARD_COUNT", columnDefinition = "INT")
    val cardCount: Int,

    @Column(name = "MEMBER_CARD_TOTAL_PRICE", columnDefinition = "INT")
    val cardTotalPrice: Double,

    @Column(name = "MEMBER_RANK", columnDefinition = "VARCHAR(20)")
    @Enumerated(EnumType.STRING)
    val rank: Rank,

    @Column(name = "MEMBER_REG_DATE", columnDefinition = "TIMESTAMP")
    val regDate: LocalDateTime
)