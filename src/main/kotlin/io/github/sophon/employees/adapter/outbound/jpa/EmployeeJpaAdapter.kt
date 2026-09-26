package io.github.sophon.employees.adapter.outbound.jpa

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee
import io.github.sophon.employees.application.port.outbound.EmployeePersistencePort
import org.springframework.stereotype.Repository

@Repository
internal class EmployeeJpaAdapter(
    private val dao: EmployeeDao,
): EmployeePersistencePort {
    override fun save(newEmployee: NewEmployee): Employee {
        val entity = newEmployee.toEntity()
        dao.save(entity)

        val employee = entity.toDomain()
        return employee
    }
}
