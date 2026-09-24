package io.github.sophon.employees.adapter.out.persistence

import io.github.sophon.employees.application.domain.exception.EmployeeNotFoundException
import io.github.sophon.employees.application.domain.model.Employee
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

internal interface EmployeeDao {
    fun findAll(): List<Employee>
    fun findById(id: Long): Employee?
    fun save(employee: Employee): Employee
    fun delete(id: Long)
}

@Repository
internal class EmployeeDaoJpaImpl(
    @Autowired private val entityManager: EntityManager,
): EmployeeDao {

    override fun findAll(): List<Employee> {
        val query = entityManager.createQuery(
            "FROM $NAME_TABLE_EMPLOYEE",
            EmployeeJpaEntity::class.java,
        )

        val employeeList = query.resultList.map { it.toDomain() }
        return employeeList
    }

    override fun findById(id: Long): Employee? {
        val entity: EmployeeJpaEntity = entityManager.find(
            EmployeeJpaEntity::class.java,
            id,
        ) ?: return null

        val employee = entity.toDomain()
        return employee
    }

    override fun save(employee: Employee): Employee {
        val entity = employee.toEntity()
        val mergedEntity = entityManager.merge(entity)

        val mergedEmployee = mergedEntity.toDomain()
        return mergedEmployee
    }

    override fun delete(id: Long) {
        val entity: EmployeeJpaEntity = entityManager.find(
            EmployeeJpaEntity::class.java,
            id,
        ) ?: throw EmployeeNotFoundException(id)

        entityManager.remove(entity)
    }
}
