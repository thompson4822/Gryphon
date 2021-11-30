package com.overbyte.gryphon.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "rental")
@Entity
open class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "inventory_item_id", nullable = false)
    open var inventoryItem: InventoryItem? = null

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "person_id", nullable = false)
    open var person: Person? = null

    @Column(name = "rental_date", nullable = false)
    open var rentalDate: LocalDateTime? = null

    @Column(name = "due_date", nullable = false)
    open var dueDate: LocalDateTime? = null

    @Column(name = "return_date")
    open var returnDate: LocalDateTime? = null

    @Column(name = "credit_amount", precision = 19, scale = 2)
    open var creditAmount: BigDecimal? = null

    @Column(name = "tax", precision = 19, scale = 2)
    open var tax: BigDecimal? = null

    @Column(name = "subtotal", precision = 19, scale = 2)
    open var subtotal: BigDecimal? = null
}