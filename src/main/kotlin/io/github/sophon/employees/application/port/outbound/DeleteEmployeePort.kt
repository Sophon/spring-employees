package io.github.sophon.employees.application.port.outbound

internal fun interface DeleteEmployeePort {
    fun delete(id: Long): Boolean
}
