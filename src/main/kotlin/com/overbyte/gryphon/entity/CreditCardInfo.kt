package com.overbyte.gryphon.entity

import java.time.LocalDate
import javax.persistence.*

@Table(name = "credit_card_info")
@Entity
open class CreditCardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "number", nullable = false, unique = true)
    open var number: String? = null

    @Column(name = "expiration")
    open var expiration: LocalDate? = null

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "person_id", nullable = false)
    open var person: Person? = null
}