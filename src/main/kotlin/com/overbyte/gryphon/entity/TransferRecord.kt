package com.overbyte.gryphon.entity

import javax.persistence.*

@Table(name = "transfer_record")
@Entity
open class TransferRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(cascade = [CascadeType.ALL], optional = false)
    @JoinColumn(name = "inventory_transfer_id", nullable = false)
    open var inventoryTransfer: InventoryTransfer? = null

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "inventory_item_id", nullable = false)
    open var inventoryItem: InventoryItem? = null
}