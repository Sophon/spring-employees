package io.github.sophon.employees.adapter.`in`.web

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.port.`in`.FindAllEmployeesUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
internal class EmployeeRestController(
    private val findAllEmployeesUseCase: FindAllEmployeesUseCase,
) {

    @GetMapping
    fun findAll(): List<Employee> {
        val employeeList = findAllEmployeesUseCase()
        return employeeList
    }
}
