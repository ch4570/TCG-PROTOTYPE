package com.splab.backend.homework.member.validation

import com.splab.backend.homework.member.repository.MemberRepository
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NotDuplicatedEmailValidator(
    private val memberRepository: MemberRepository
) : ConstraintValidator<NotDuplicatedEmail, String> {


    override fun isValid(email: String?, context: ConstraintValidatorContext?): Boolean {
        val findMember = memberRepository.findByMemberEmail(email!!)
        return findMember == null
    }
}