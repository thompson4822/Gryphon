package com.overbyte.gryphon.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "employee")
@Entity
open class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "ssn")
    open var ssn: String? = null

    @Column(name = "hire_date", nullable = false)
    open var hireDate: LocalDateTime? = null

    @Column(name = "exit_date")
    open var exitDate: LocalDateTime? = null

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "person_id")
    open var person: Person? = null

    @ManyToOne
    @JoinColumn(name = "store_id")
//    @JsonBackReference
    open var store: Store? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    open var role: Role? = null

    @Column(name = "hourly_rate", precision = 19, scale = 2)
    open var hourlyRate: BigDecimal? = null
}