package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee
import io.github.sophon.employees.application.port.inbound.CreateEmployeeUseCase
import io.github.sophon.employees.application.port.outbound.EmployeePersistencePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
internal class CreateEmployeeService(
    private val employeePersistencePort: EmployeePersistencePort,
) : CreateEmployeeUseCase {
    override operator fun invoke(employee: NewEmployee): Employee {
        val newEmployee = employeePersistencePort.save(employee)
        return newEmployee
    }
}
