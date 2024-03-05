package com.splab.backend.homework.member.controller

import com.splab.backend.homework.member.dto.request.CreateMemberCommand
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
class RegisterMemberController {

    @GetMapping("/registerForm")
    fun memberRegisterForm(model: Model) : String {
        val memberFormData = CreateMemberCommand(name = null, email = null, regDate = null)
        model.addAttribute("memberFormData", memberFormData)
        return "registerMemberForm"
    }

    @PostMapping("/submitForm")
    fun submitMember(@Valid @ModelAttribute("memberFormData") memberFormData: CreateMemberCommand,
                     bindingResult: BindingResult) : String {
        if (bindingResult.hasErrors())
            return "registerMemberForm"

        return "redirect:/members/list"
    }
}