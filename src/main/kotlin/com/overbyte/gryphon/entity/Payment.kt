package com.overbyte.gryphon.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "payment")
@Entity
open class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "amount", nullable = false, precision = 19, scale = 2)
    open var amount: BigDecimal? = null

    @Column(name = "date_paid", nullable = false)
    open var datePaid: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "credit_card_info_id")
    open var creditCardInfo: CreditCardInfo? = null
}