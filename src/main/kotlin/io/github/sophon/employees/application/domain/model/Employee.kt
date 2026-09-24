package io.github.sophon.employees.application.domain.model

internal data class Employee(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
)
