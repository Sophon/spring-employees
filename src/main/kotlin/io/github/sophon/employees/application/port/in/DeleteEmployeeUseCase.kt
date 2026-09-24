package io.github.sophon.employees.application.port.`in`

internal interface DeleteEmployeeUseCase {
    operator fun invoke(id: Long)
}
