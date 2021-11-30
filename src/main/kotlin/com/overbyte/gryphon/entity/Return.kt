package com.overbyte.gryphon.entity

import javax.persistence.*

@Table(name = "return")
@Entity
open class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "store_id")
    open var store: Store? = null
}