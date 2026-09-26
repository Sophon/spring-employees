package io.github.sophon.employees.adapter.`in`.web

import io.github.sophon.employees.application.domain.exception.EmployeeNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
internal class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException::class)
    fun handleEmployeeNotFound(exception: EmployeeNotFoundException): ProblemDetail {
        val problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.message)
        return problemDetail
    }
}
