package io.github.sophon.employees.adapter.`in`.web

import io.github.sophon.employees.application.domain.model.Employee

internal fun EmployeeRequestDto.toDomain(id: Long): Employee {
    val employee = Employee(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
    )
    return employee
}
