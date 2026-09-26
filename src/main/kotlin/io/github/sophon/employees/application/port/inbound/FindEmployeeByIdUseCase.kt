package io.github.sophon.employees.application.port.inbound

import io.github.sophon.employees.application.domain.model.Employee

internal interface FindEmployeeByIdUseCase {
    operator fun invoke(id: Long): Employee
}
