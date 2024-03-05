package com.splab.backend.homework.member.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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

    @Column(name = "MEMBER_REG_DATE", columnDefinition = "TIMESTAMP")
    val regDate: LocalDateTime
)