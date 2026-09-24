package io.github.sophon.employees.application.domain.exception

internal class EmployeeNotFoundException(
    val id: Int,
): RuntimeException("Employee with id $id not found.")
