package com.splab.backend.homework.common.dto

import com.fasterxml.jackson.annotation.JsonInclude

data class BaseResponse<T>(
    val status: Int,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val data: T?,
    val message: String
) {

    companion object {

        fun ok() : BaseResponse<Any?> {
            return BaseResponse(
                status = 200,
                data = null,
                message = "OK"
            )
        }

        fun internalServerError(exception: Exception) : BaseResponse<Exception> {
            return BaseResponse(
                500,
                data = exception,
                message = "INTERNAL SERVER ERROR"
            )
        }
    }
}