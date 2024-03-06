package com.splab.backend.homework.member.controller

import com.splab.backend.homework.member.dto.response.MemberResponse
import com.splab.backend.homework.member.repository.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/members")
class LoadMemberController(
    private val memberRepository: MemberRepository
) {

    @GetMapping("/list")
    fun loadMemberList(model: Model) : String {
        val memberList = memberRepository.findAll()
            .map {
                member -> MemberResponse(
                    memberId = member.memberId!!,
                    name = member.name,
                    email = member.email,
                    regDate = member.regDate,
                    level = member.level,
                    cardCount = member.cardCount
                )
            }
        model.addAttribute("memberList", memberList)
        return "loadMemberList"
    }
}