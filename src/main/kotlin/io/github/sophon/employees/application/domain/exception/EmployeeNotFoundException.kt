package io.github.sophon.employees.application.domain.exception

internal class EmployeeNotFoundException(
    val id: Long,
): RuntimeException("Employee with id $id not found.")
