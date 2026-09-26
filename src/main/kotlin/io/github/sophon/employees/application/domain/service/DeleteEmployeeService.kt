package io.github.sophon.employees.application.domain.service

import io.github.sophon.employees.application.domain.exception.EmployeeNotFoundException
import io.github.sophon.employees.application.port.inbound.DeleteEmployeeUseCase
import io.github.sophon.employees.application.port.outbound.DeleteEmployeePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
internal class DeleteEmployeeService(
    private val deleteEmployeePort: DeleteEmployeePort,
) : DeleteEmployeeUseCase {
    override operator fun invoke(id: Long) {
        val deleted = deleteEmployeePort.delete(id)
        if (deleted.not()) throw EmployeeNotFoundException(id)
    }
}
