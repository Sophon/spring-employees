package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.adapter.out.persistence.EmployeeDao
import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.port.inbound.FindAllEmployeesUseCase
import org.springframework.stereotype.Service

// TODO: depend on an output port instead of the DAO adapter directly.
@Service
internal class FindAllEmployeesService(
    private val employeeDao: EmployeeDao,
) : FindAllEmployeesUseCase {
    override operator fun invoke(): List<Employee> {
        val employeeList = employeeDao.findAll()
        return employeeList
    }
}
