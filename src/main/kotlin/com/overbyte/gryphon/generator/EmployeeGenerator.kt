package com.overbyte.gryphon.generator

import com.overbyte.gryphon.entity.Employee
import com.overbyte.gryphon.entity.Role
import com.overbyte.gryphon.entity.Store
import java.math.BigDecimal
import java.time.LocalDateTime
import kotlin.random.Random
import kotlin.random.nextLong

object EmployeeGenerator {
    val rand = Random(System.currentTimeMillis())

    fun next(roles: List<Role>, currentStore: Store) : Employee {
        val whenHired = LocalDateTime.now()
        return Employee().apply {
            hireDate = whenHired
            person = PersonGenerator.next()
            ssn = "${rand.nextLong(100000000L .. 999999999L)}"
            role = roles[rand.nextInt(roles.count())]
            store = currentStore
            hourlyRate = hourlyEarning
        }
    }

    // Later this can be computed based on role if we want to go that route
    private val hourlyEarning: BigDecimal
        get() = BigDecimal(15.00)
}