package com.overbyte.gryphon.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.NotNull

@Table(name = "product")
@Entity
open class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @NotNull(message = "A product must have a name")
    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "description")
    open var description: String? = null

    @Column(name = "publisher")
    open var publisher: String? = null

    @NotNull(message = "A product must have a base cost")
    @Column(name = "base_cost", nullable = false, precision = 19, scale = 2)
    open var baseCost: BigDecimal? = null

    @Lob
    @Column(name = "image")
    open var image: ByteArray? = null
}