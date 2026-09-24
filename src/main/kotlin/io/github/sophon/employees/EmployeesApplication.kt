package io.github.sophon.employees

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmployeesApplication

fun main(args: Array<String>) {
	runApplication<EmployeesApplication>(*args)
}
