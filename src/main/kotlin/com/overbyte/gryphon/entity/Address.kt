package com.overbyte.gryphon.entity

import com.overbyte.gryphon.enumerations.StateAbbreviation
import javax.persistence.*

@Embeddable
open class Address {
    @Column(name = "address_line_1")
    open var addressLine1: String? = null

    @Column(name = "address_line_2")
    open var addressLine2: String? = null

    @Column(name = "city")
    open var city: String? = null

    @Enumerated(value = EnumType.STRING)
    open var state: StateAbbreviation? = null

    @Column(name = "zip_code", length = 13)
    open var zipCode: String? = null
}