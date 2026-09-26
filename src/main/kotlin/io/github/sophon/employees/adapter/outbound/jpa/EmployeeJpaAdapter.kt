package io.github.sophon.employees.adapter.outbound.jpa

import io.github.sophon.employees.application.domain.model.Employee
import io.github.sophon.employees.application.domain.model.NewEmployee
import io.github.sophon.employees.application.port.outbound.CreateEmployeePort
import io.github.sophon.employees.application.port.outbound.DeleteEmployeePort
import io.github.sophon.employees.application.port.outbound.FindEmployeePort
import io.github.sophon.employees.application.port.outbound.UpdateEmployeePort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
internal class EmployeeJpaAdapter(
    private val dao: EmployeeDao,
): CreateEmployeePort, DeleteEmployeePort, FindEmployeePort, UpdateEmployeePort {
    override fun create(newEmployee: NewEmployee): Employee {
        val entity = newEmployee.toEntity()
        dao.save(entity)
        val employee = entity.toDomain()
        return employee
    }

    override fun delete(id: Long): Boolean {
        val entity = dao.findByIdOrNull(id) ?: return false
        dao.delete(entity)
        return true
    }

    override fun find(): List<Employee> {
        val entityList = dao.findAll()
        val employeeList = entityList.map { it.toDomain() }
        return employeeList
    }

    override fun find(id: Long): Employee? {
        val employee = dao.findByIdOrNull(id)?.toDomain()
        return employee
    }

    override fun update(employee: Employee): Employee {
        val entity = employee.toEntity()
        val savedEntity = dao.save(entity)
        val updatedEmployee = savedEntity.toDomain()
        return updatedEmployee
    }
}
