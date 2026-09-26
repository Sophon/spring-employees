package io.github.sophon.employees.adapter.out.persistence

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee

internal fun EmployeeJpaEntity.toDomain(): Employee {
    val id = requireNotNull(this.id) { "Entity must have an ID." }

    val employee = Employee(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
    )
    return employee
}

internal fun NewEmployee.toEntity(): EmployeeJpaEntity {
    val entity = EmployeeJpaEntity(
        firstName = firstName,
        lastName = lastName,
        email = email,
    )
    return entity
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
