package io.github.sophon.employees.data

import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

internal interface EmployeeDao {
    fun get(): List<EmployeeEntity>
    fun get(id: Int): EmployeeEntity
    fun add(entity: EmployeeEntity)
    fun update(entity: EmployeeEntity): EmployeeEntity
    fun delete(id: Int)
}

@Repository
internal class EmployeeDaoJpaImpl(
    @Autowired private val entityManager: EntityManager,
): EmployeeDao {

    override fun get(): List<EmployeeEntity> {
        val query = entityManager.createQuery(
            "FROM $NAME_TABLE_EMPLOYEE",
            EmployeeEntity::class.java,
        )

        val employeeList = query.resultList

        return employeeList
    }

    override fun get(id: Int): EmployeeEntity {
        TODO("Not yet implemented")
    }

    override fun add(entity: EmployeeEntity) {
        TODO("Not yet implemented")
    }

    override fun update(entity: EmployeeEntity): EmployeeEntity {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}