package com.splab.backend.homework.member.controller

import com.splab.backend.homework.member.dto.response.MemberResponse
import com.splab.backend.homework.member.entity.Level
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDate

@Controller
@RequestMapping("/members")
class LoadMemberController {

    @GetMapping("/list")
    fun loadMemberList(model: Model) : String {
        model.addAttribute("memberList", getMockMembers())
        return "loadMemberList"
    }

    private fun getMockMembers() : List<MemberResponse> {

        val memberList = mutableListOf<MemberResponse>()

        for (i in 1..20) {
            val memberResponse = MemberResponse(
                id = i.toLong(),
                name = "서민재$i",
                email = "mj.seo$i@google.com",
                regDate = LocalDate.now(),
                level = Level.BRONZE,
                cardCount = 21
            )

            memberList.add(memberResponse)
        }

        return memberList
    }
}