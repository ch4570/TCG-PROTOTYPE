package com.splab.backend.homework.member.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(allowedTargets = [AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER])
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [DateRangeValidator::class])
annotation class DateRange(
    val message: String = "가입 일자는 현재 날짜 또는 1년 이내의 날짜만 가능합니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
