package com.overbyte.gryphon.entity

import javax.persistence.*

@Table(name = "payment_type")
@Entity
open class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false, unique = true)
    open var name: String? = null
}