package io.github.sophon.employees.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity(name = NAME_TABLE_EMPLOYEE)
@Table(name = NAME_TABLE_EMPLOYEE)
internal data class EmployeeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int,

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "last_name")
    val lastName: String,

    @Column(name = "email")
    val email: String,
)

internal const val NAME_TABLE_EMPLOYEE = "employee"
