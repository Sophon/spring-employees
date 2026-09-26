package io.github.sophon.employees.adapter.`in`.web

import io.github.sophon.employees.application.domain.model.NewEmployee

internal fun EmployeeRequestDto.toDomain(): NewEmployee {
    val employee = NewEmployee(
        firstName = firstName,
        lastName = lastName,
        email = email,
    )
    return employee
}
