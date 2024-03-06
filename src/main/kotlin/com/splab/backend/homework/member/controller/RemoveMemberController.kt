package com.splab.backend.homework.member.controller

import com.splab.backend.homework.common.dto.BaseResponse
import com.splab.backend.homework.member.service.RemoveMemberUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class RemoveMemberController(
    private val removeMemberUseCase: RemoveMemberUseCase
) {

    @DeleteMapping("/{memberId}")
    fun removeMember(@PathVariable("memberId") memberId: Long) :
            ResponseEntity<BaseResponse<Any?>> {
        removeMemberUseCase.removeMember(memberId)
        return ResponseEntity.ok(BaseResponse.ok())
    }
}