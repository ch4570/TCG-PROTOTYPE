package com.splab.backend.homework.common

import com.splab.backend.homework.member.entity.Level
import com.splab.backend.homework.member.entity.Member
import com.splab.backend.homework.member.repository.MemberRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Component
@Transactional
class DataInitEvent(
    private val memberRepository: MemberRepository
) {

    @EventListener(ApplicationReadyEvent::class)
    fun insertDummyUsers() {
        val memberList = mutableListOf<Member>()

        for (i in 1..20) {
            val memberResponse = Member(
                name = "서민재$i",
                email = "mj.seo$i@google.com",
                regDate = LocalDate.now(),
                level = Level.entries[i % 3],
                cardCount = i,
                cardTotalPrice = 1009.21
            )

            memberList.add(memberResponse)
        }

        memberRepository.saveAll(memberList)
    }
}