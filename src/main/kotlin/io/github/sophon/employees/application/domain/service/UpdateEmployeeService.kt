package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.application.domain.exception.EmployeeNotFoundException
import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee
import io.github.sophon.employees.application.port.inbound.UpdateEmployeeUseCase
import io.github.sophon.employees.application.port.outbound.FindEmployeePort
import io.github.sophon.employees.application.port.outbound.UpdateEmployeePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
internal class UpdateEmployeeService(
    private val findEmployeePort: FindEmployeePort,
    private val updateEmployeePort: UpdateEmployeePort,
) : UpdateEmployeeUseCase {
    override operator fun invoke(id: Long, employee: NewEmployee): Employee {
        val existingEmployee = findEmployeePort.find(id)
            ?: throw EmployeeNotFoundException(id)

        val changedEmployee = existingEmployee.copy(
            firstName = employee.firstName,
            lastName = employee.lastName,
            email = employee.email,
        )
        val updatedEmployee = updateEmployeePort.update(changedEmployee)
        return updatedEmployee
    }
}
