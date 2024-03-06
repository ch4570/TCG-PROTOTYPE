package com.splab.backend.homework.member.controller

import com.splab.backend.homework.member.dto.request.ModifyMemberCommand
import com.splab.backend.homework.member.service.LoadMemberUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/members")
class ModifyMemberController(
    private val loadMemberUseCase: LoadMemberUseCase
) {

    @GetMapping("/modifyForm")
    fun memberModifyForm(@RequestParam("memberId") memberId: Long, model: Model) : String{
        val findMember = loadMemberUseCase.loadMemberById(memberId)

        findMember?.let {
            val memberModifyFormData = ModifyMemberCommand(
                memberId = it.memberId!!,
                memberName = it.memberName,
                memberEmail = it.memberEmail,
                regDate = it.regDate
            )
            model.addAttribute("memberModifyFormData", memberModifyFormData)
        }

        return "modifyMemberForm"
    }
}