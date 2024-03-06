package com.splab.backend.homework.member.entity

import com.splab.backend.homework.common.entity.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Game(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID", columnDefinition = "INT")
    val gameId: Long? = null,

    @Column(name = "GAME_NAME", columnDefinition = "VARCHAR(100)")
    val gameName: String
) : BaseTimeEntity()