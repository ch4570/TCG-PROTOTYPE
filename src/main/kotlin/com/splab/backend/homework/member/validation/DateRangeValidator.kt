package com.splab.backend.homework.member.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class DateRangeValidator : ConstraintValidator<DateRange, LocalDateTime> {
    override fun isValid(value: LocalDateTime?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true

        val today = LocalDateTime.now()
        val oneYearAgo = today.minus(1, ChronoUnit.YEARS)

        return !value.isAfter(today) && !value.isBefore(oneYearAgo)
    }
}