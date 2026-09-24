package io.github.sophon.employees.application.port.`in`

import io.github.sophon.employees.application.domain.model.Employee

internal interface CreateEmployeeUseCase {
    operator fun invoke(employee: Employee): Employee?
}
