package io.github.sophon.employees.application.port.outbound

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee

internal fun interface CreateEmployeePort {
    fun create(newEmployee: NewEmployee): Employee
}
