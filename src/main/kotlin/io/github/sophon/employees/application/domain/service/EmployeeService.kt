package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.adapter.out.persistence.EmployeeDao
import io.github.sophon.employees.application.domain.model.Employee
import org.springframework.stereotype.Service

internal interface EmployeeService {
    fun findAll(): List<Employee>
    fun findById(id: Long): Employee?
    fun save(employee: Employee)
    fun deleteById(id: Long)
}


@Service
internal class EmployeeServiceImpl(
    private val employeeDao: EmployeeDao,
): EmployeeService {
    override fun findAll(): List<Employee> {
        val employeeList = employeeDao.findAll()
        return employeeList
    }

    override fun findById(id: Long): Employee? {
        val employee = employeeDao.findById(id)
        return employee
    }

    override fun save(employee: Employee) {
        employeeDao.save(employee)
    }

    override fun deleteById(id: Long) {
        employeeDao.delete(id)
    }
}
