package com.overbyte.gryphon.entity

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "inventory_transfer")
@Entity
open class InventoryTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_from_id", nullable = false)
    open var storeFrom: Store? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_to_id", nullable = false)
    open var storeTo: Store? = null

    @Column(name = "transfer_date", nullable = false)
    open var transferDate: LocalDateTime? = null

    @OneToMany(mappedBy = "inventoryTransfer", orphanRemoval = true)
    open var transferRecords: MutableSet<TransferRecord> = mutableSetOf()
}