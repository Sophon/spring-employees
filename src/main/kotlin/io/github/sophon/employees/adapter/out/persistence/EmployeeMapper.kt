package io.github.sophon.employees.adapter.out.persistence

import io.github.sophon.employees.application.domain.model.Employee

internal fun EmployeeJpaEntity.toDomain(): Employee {
    val employee = Employee(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
    )
    return employee
}

internal fun Employee.toEntity(): EmployeeJpaEntity {
    val entity = EmployeeJpaEntity(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
    )
    return entity
}
