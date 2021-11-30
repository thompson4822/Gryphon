package com.overbyte.gryphon.dto

import com.overbyte.gryphon.entity.Person
import com.overbyte.gryphon.entity.Role
import com.overbyte.gryphon.entity.Store
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

data class EmployeeDto(
    val id: Long? = null,
    val ssn: String? = null,
    val hireDate: LocalDateTime? = null,
    val exitDate: LocalDateTime? = null,
    val person: Person? = null,
    val role: Role? = null,
    val hourlyRate: BigDecimal? = null
)
