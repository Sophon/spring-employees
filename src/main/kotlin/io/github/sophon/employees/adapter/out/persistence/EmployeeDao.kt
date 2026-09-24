package io.github.sophon.employees.adapter.out.persistence

import io.github.sophon.employees.application.domain.model.Employee
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

internal interface EmployeeDao {
    fun get(): List<Employee>
    fun get(id: Int): Employee
    fun add(employee: Employee)
    fun update(employee: Employee): Employee
    fun delete(id: Int)
}

@Repository
internal class EmployeeDaoJpaImpl(
    @Autowired private val entityManager: EntityManager,
): EmployeeDao {

    override fun get(): List<Employee> {
        val query = entityManager.createQuery(
            "FROM $NAME_TABLE_EMPLOYEE",
            EmployeeJpaEntity::class.java,
        )

        val employeeList = query.resultList.map { it.toDomain() }

        return employeeList
    }

    override fun get(id: Int): Employee {
        TODO("Not yet implemented")
    }

    override fun add(employee: Employee) {
        val entity = employee.toEntity()
        TODO("Not yet implemented")
    }

    override fun update(employee: Employee): Employee {
        val entity = employee.toEntity()
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}
