package com.splab.backend.homework.member.controller

import com.splab.backend.homework.member.dto.request.CreateMemberCommand
import com.splab.backend.homework.member.service.CreateMemberUseCase
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/members")
class RegisterMemberController(
    private val createMemberUseCase: CreateMemberUseCase
) {

    @GetMapping("/registerForm")
    fun memberRegisterForm(model: Model) : String {
        val memberRegisterFormData = CreateMemberCommand(memberName = null, memberEmail = null, regDate = null)
        model.addAttribute("memberRegisterFormData", memberRegisterFormData)
        return "registerMemberForm"
    }

    @PostMapping("/register")
    fun submitMember(@Valid @ModelAttribute("memberRegisterFormData") memberFormData: CreateMemberCommand,
                     bindingResult: BindingResult) : String {
        if (bindingResult.hasErrors())
            return "registerMemberForm"

        createMemberUseCase.createMember(memberFormData)

        return "redirect:/members/list"
    }
}