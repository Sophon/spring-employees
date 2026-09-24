package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.adapter.out.persistence.EmployeeDao
import io.github.sophon.employees.application.domain.exception.EmployeeNotFoundException
import io.github.sophon.employees.application.port.`in`.DeleteEmployeeUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

// TODO: depend on an output port instead of the DAO adapter directly.
@Service
@Transactional
internal class DeleteEmployeeService(
    private val employeeDao: EmployeeDao,
) : DeleteEmployeeUseCase {
    override operator fun invoke(id: Long) {
        val deleted = employeeDao.delete(id)
        if (deleted.not()) throw EmployeeNotFoundException(id)
    }
}
