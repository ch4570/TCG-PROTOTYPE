package com.splab.backend.homework.member.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class DateRangeValidator : ConstraintValidator<DateRange, LocalDate> {
    override fun isValid(value: LocalDate?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return true

        val today = LocalDate.now()
        val oneYearAgo = today.minus(1, ChronoUnit.YEARS)

        return !value.isAfter(today) && !value.isBefore(oneYearAgo)
    }
}