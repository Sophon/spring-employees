package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.port.inbound.FindAllEmployeesUseCase
import io.github.sophon.employees.application.port.outbound.FindEmployeePort
import org.springframework.stereotype.Service

@Service
internal class FindAllEmployeesService(
    private val findEmployeePort: FindEmployeePort,
) : FindAllEmployeesUseCase {
    override operator fun invoke(): List<Employee> {
        val employeeList = findEmployeePort.find()
        return employeeList
    }
}
