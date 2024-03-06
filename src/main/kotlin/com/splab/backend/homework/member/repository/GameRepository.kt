package com.splab.backend.homework.member.repository

import com.splab.backend.homework.member.entity.Game
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<Game, Long> {
}