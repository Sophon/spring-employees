package io.github.sophon.employees.adapter.`in`.web

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

internal data class EmployeeRequestDto(
    @NotBlank
    @Size(min = LIMIT_NAME_MIN, max = LIMIT_NAME_MAX)
    val firstName: String,

    @NotBlank
    @Size(min = LIMIT_NAME_MIN, max = LIMIT_NAME_MAX)
    val lastName: String,

    @NotBlank
    @Email
    val email: String,
)


internal const val LIMIT_NAME_MIN = 2
internal const val LIMIT_NAME_MAX = 50
