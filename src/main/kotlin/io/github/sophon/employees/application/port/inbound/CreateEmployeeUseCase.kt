package io.github.sophon.employees.application.port.inbound

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee

internal interface CreateEmployeeUseCase {
    operator fun invoke(newEmployee: NewEmployee): Employee
}
