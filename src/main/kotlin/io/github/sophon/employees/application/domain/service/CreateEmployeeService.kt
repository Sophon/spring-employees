package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.adapter.out.persistence.EmployeeDao
import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.port.`in`.CreateEmployeeUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

// TODO: depend on an output port instead of the DAO adapter directly.
@Service
@Transactional
internal class CreateEmployeeService(
    private val employeeDao: EmployeeDao,
) : CreateEmployeeUseCase {
    override operator fun invoke(employee: Employee): Employee? {
        employeeDao.save(employee)
        return employee
    }
}
