package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee
import io.github.sophon.employees.application.port.inbound.CreateEmployeeUseCase
import io.github.sophon.employees.application.port.outbound.CreateEmployeePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
internal class CreateEmployeeService(
    private val createEmployeePort: CreateEmployeePort,
) : CreateEmployeeUseCase {
    override operator fun invoke(newEmployee: NewEmployee): Employee {
        val createdEmployee = createEmployeePort.create(newEmployee)
        return createdEmployee
    }
}
