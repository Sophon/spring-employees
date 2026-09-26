package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.adapter.out.persistence.EmployeeDao
import io.github.sophon.employees.application.domain.exception.EmployeeNotFoundException
import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee
import io.github.sophon.employees.application.port.inbound.UpdateEmployeeUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

// TODO: depend on an output port instead of the DAO adapter directly.
@Service
@Transactional
internal class UpdateEmployeeService(
    private val employeeDao: EmployeeDao,
) : UpdateEmployeeUseCase {
    override operator fun invoke(id: Long, employee: NewEmployee): Employee {
        val existingEmployee = employeeDao.findById(id)
            ?: throw EmployeeNotFoundException(id)

        val changedEmployee = existingEmployee.copy(
            firstName = employee.firstName,
            lastName = employee.lastName,
            email = employee.email,
        )
        val updatedEmployee = employeeDao.update(changedEmployee)
        return updatedEmployee
    }
}
