package io.github.sophon.employees.adapter.`in`.web

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.port.`in`.CreateEmployeeUseCase
import io.github.sophon.employees.application.port.`in`.DeleteEmployeeUseCase
import io.github.sophon.employees.application.port.`in`.FindAllEmployeesUseCase
import io.github.sophon.employees.application.port.`in`.FindEmployeeByIdUseCase
import io.github.sophon.employees.application.port.`in`.UpdateEmployeeUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.constraints.Min
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee REST API endpoints", description = "Operations related to employees")
internal class EmployeeRestController(
    private val findAllEmployeesUseCase: FindAllEmployeesUseCase,
    private val findEmployeeByIdUseCase: FindEmployeeByIdUseCase,
    private val createEmployeeUseCase: CreateEmployeeUseCase,
    private val updateEmployeeUseCase: UpdateEmployeeUseCase,
    private val deleteEmployeeUseCase: DeleteEmployeeUseCase,
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all employees", description = "Get a list of all employees")
    fun findAll(): List<Employee> {
        val employeeList = findAllEmployeesUseCase()
        return employeeList
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get an employee", description = "Get an employee by ID")
    fun findById(
        @PathVariable @Min(value = 1)
        id: Long,
    ): Employee {
        val employee = findEmployeeByIdUseCase(id)
        return employee
    }

    @PostMapping
    @Operation(summary = "Create an employee", description = "Create a new employee")
    fun createEmployee(
        @RequestBody employeeRequestDto: EmployeeRequestDto,
    ): Employee {
        val employee = employeeRequestDto.toDomain(id = 0) //TODO: properly form ID
        createEmployeeUseCase(employee)

        return employee
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an employee", description = "Update an employee of ID")
    fun updateEmployee(
        @PathVariable id: Long,
        @RequestBody employeeRequestDto: EmployeeRequestDto,
    ): Employee {
        val updatedEmployee = employeeRequestDto.toDomain(id)
        updateEmployeeUseCase(id = id, employee = updatedEmployee)

        return updatedEmployee
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an employee", description = "Delete an employee by ID")
    fun deleteEmployee(
        @PathVariable id: Long,
    ) {
        deleteEmployeeUseCase(id)
    }
}
