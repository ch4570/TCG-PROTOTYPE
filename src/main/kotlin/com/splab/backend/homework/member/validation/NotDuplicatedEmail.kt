package com.splab.backend.homework.member.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(allowedTargets = [AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER])
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NotDuplicatedEmailValidator::class])
annotation class NotDuplicatedEmail(
    val message: String = "이미 등록된 이메일입니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
