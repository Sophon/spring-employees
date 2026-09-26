package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.application.domain.exception.EmployeeNotFoundException
import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.port.inbound.FindEmployeeByIdUseCase
import io.github.sophon.employees.application.port.outbound.FindEmployeePort
import org.springframework.stereotype.Service

@Service
internal class FindEmployeeByIdService(
    private val findEmployeePort: FindEmployeePort,
) : FindEmployeeByIdUseCase {
    override operator fun invoke(id: Long): Employee {
        val employee = findEmployeePort.find(id) ?: throw EmployeeNotFoundException(id)
        return employee
    }
}
