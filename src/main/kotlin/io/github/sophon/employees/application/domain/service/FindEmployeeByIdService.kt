package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.adapter.out.persistence.EmployeeDao
import io.github.sophon.employees.application.domain.exception.EmployeeNotFoundException
import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.port.inbound.FindEmployeeByIdUseCase
import org.springframework.stereotype.Service

// TODO: depend on an output port instead of the DAO adapter directly.
@Service
internal class FindEmployeeByIdService(
    private val employeeDao: EmployeeDao,
) : FindEmployeeByIdUseCase {
    override operator fun invoke(id: Long): Employee {
        val employee = employeeDao.findById(id) ?: throw EmployeeNotFoundException(id)
        return employee
    }
}
