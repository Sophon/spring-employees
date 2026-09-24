package io.github.sophon.employees.application.domain.model

internal data class Employee(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
)
