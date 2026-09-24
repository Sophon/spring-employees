package io.github.sophon.employees

import io.github.sophon.employees.data.EmployeeDao
import io.github.sophon.employees.model.EmployeeEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
internal class EmployeeRestController(
    private val employeeDao: EmployeeDao,
) {

    @GetMapping
    fun findAll(): List<EmployeeEntity> {
        val result = employeeDao.get()
        return result
    }
}
