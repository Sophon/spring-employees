package io.github.sophon.employees.application.port.outbound

import io.github.sophon.employees.application.domain.model.Employee

internal interface FindEmployeePort {
    fun find(id: Long): Employee?
    fun find(): List<Employee>
}
