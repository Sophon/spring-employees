package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.adapter.out.persistence.EmployeeDao
import io.github.sophon.employees.application.domain.model.Employee
import org.springframework.stereotype.Service

internal interface EmployeeService {
    fun findAll(): List<Employee>
}


@Service
internal class EmployeeServiceImpl(
    private val employeeDao: EmployeeDao,
): EmployeeService {
    override fun findAll(): List<Employee> {
        val employeeList = employeeDao.findAll()
        return employeeList
    }
}
