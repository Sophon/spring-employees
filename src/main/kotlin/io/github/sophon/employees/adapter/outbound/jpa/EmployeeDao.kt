package io.github.sophon.employees.adapter.outbound.jpa

import org.springframework.data.jpa.repository.JpaRepository

internal interface EmployeeDao: JpaRepository<EmployeeJpaEntity, Long>
