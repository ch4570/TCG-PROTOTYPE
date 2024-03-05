package com.splab.backend.homework.member.dto.request

import com.splab.backend.homework.member.validation.DateRange
import com.splab.backend.homework.member.validation.NotDuplicatedEmail
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class CreateMemberCommand(

    @NotBlank(message = "이름은 비어있을 수 없습니다.")
    @Length(min = 2, max = 100, message = "이름은 2자 이상 100자의 길이여야 합니다.")
    @Pattern(regexp = "^[a-zA-Z가-힣]*$", message = "한글 또는 영어만 입력할 수 있습니다.")
    val name: String,

    @NotDuplicatedEmail
    @NotBlank(message = "이메일은 비어있을 수 없습니다.")
    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}\$",
        message = "이메일 형식에 맞지 않습니다.")
    val email: String,

    @DateRange
    @NotBlank(message = "가입 날짜는 비어있을 수 없습니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val regDate: LocalDateTime
)