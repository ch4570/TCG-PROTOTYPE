package com.splab.backend.homework.common.util

import com.splab.backend.homework.member.entity.Game
import com.splab.backend.homework.member.entity.Level
import com.splab.backend.homework.member.entity.Member
import com.splab.backend.homework.member.repository.GameRepository
import com.splab.backend.homework.member.repository.MemberRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Component
@Transactional
class DataInitEvent(
    private val memberRepository: MemberRepository,
    private val gameRepository: GameRepository
) {

    @EventListener(ApplicationReadyEvent::class)
    fun insertDummyUsersAndGames() {
        val memberList = mutableListOf<Member>()

        for (i in 1..20) {
            val memberResponse = Member(
                memberName = "서민재$i",
                memberEmail = "mj.seo$i@google.com",
                regDate = LocalDate.now(),
                level = Level.entries[i % 3],
                cardCount = i,
                cardTotalPrice = 1009.21
            )

            memberList.add(memberResponse)
        }

        memberRepository.saveAll(memberList)

        val gameList = listOf(Game(gameName = "유희왕")
                        ,Game(gameName = "매직 더 게더링"),
                        Game(gameName = "포켓몬"))

        gameRepository.saveAll(gameList)
    }
}