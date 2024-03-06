package com.splab.backend.homework.common.exception

import com.splab.backend.homework.common.dto.BaseResponse
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    protected fun handleException(exception: Exception) : ResponseEntity<BaseResponse<Exception>> {
        logger.error("요청 처리 중 에러 발생")
        logger.error("에러 내용 = {}", exception)

        return ResponseEntity.internalServerError()
            .body(BaseResponse.internalServerError(exception))
    }
}