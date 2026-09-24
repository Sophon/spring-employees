package io.github.sophon.employees.adapter.`in`.web

import io.github.sophon.employees.adapter.out.persistence.EmployeeDao
import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
internal class EmployeeRestController(
    private val employeeService: EmployeeService,
) {

    @GetMapping
    fun findAll(): List<Employee> {
        val employeeList = employeeService.findAll()
        return employeeList
    }
}
