package com.overbyte.gryphon.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "inventory_item")
@Entity
open class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "store_id")
    open var store: Store? = null

    @Column(name = "barcode", nullable = false)
    open var barcode: String? = null

    @Column(name = "tracked")
    open var tracked: LocalDateTime? = null

    @ManyToOne(cascade = arrayOf(CascadeType.MERGE))
    @JoinColumn(name = "product_id")
//    @JsonBackReference
    open var product: Product? = null
}