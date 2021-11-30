package com.overbyte.gryphon.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.math.BigDecimal
import java.sql.Blob
import javax.persistence.*
import javax.validation.constraints.Email

@Table(name = "store")
@Entity
open class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Embedded
    open var address: Address? = null

    @Column(name = "phone")
    open var phone: String? = null

    @Email(message = "Must be a valid email")
    @Column(name = "email")
    open var email: String? = null

    @Column(name = "website")
    open var website: String? = null

    @Column(name = "tax", precision = 19, scale = 2)
    open var tax: BigDecimal? = null

/*
    @OneToMany(mappedBy = "store", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    open var employees: MutableList<Employee> = mutableListOf()
*/

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "image")
    open var image: ByteArray? = null
}