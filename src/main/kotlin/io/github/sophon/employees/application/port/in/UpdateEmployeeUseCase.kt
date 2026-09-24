package io.github.sophon.employees.application.port.`in`

import io.github.sophon.employees.application.domain.model.Employee

internal interface UpdateEmployeeUseCase {
    operator fun invoke(id: Long, employee: Employee)
}
