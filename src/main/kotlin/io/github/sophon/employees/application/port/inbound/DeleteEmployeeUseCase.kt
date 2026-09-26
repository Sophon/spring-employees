package io.github.sophon.employees.application.port.inbound

internal interface DeleteEmployeeUseCase {
    operator fun invoke(id: Long)
}
