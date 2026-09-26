package io.github.sophon.employees.application.port.outbound

import io.github.sophon.employees.application.domain.model.Employee

internal fun interface UpdateEmployeePort {
    fun update(employee: Employee): Employee
}
