package com.overbyte.gryphon.entity

import com.overbyte.gryphon.enumerations.Gender
import java.math.BigDecimal
import java.sql.Blob
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Table(name = "person")
@Entity
open class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @NotNull(message = "First Name Cannot Be Null")
    @Column(name = "first_name", nullable = false)
    open var firstName: String? = null

    @NotNull(message = "Last Name Cannot Be Null")
    @Column(name = "last_name", nullable = false)
    open var lastName: String? = null

    @Column(name = "phone")
    open var phone: String? = null

    @Email(message = "Must Be A Correctly Formatted Email")
    @Column(name = "email")
    open var email: String? = null

    @Embedded
    open var address: Address? = null

    @Column(name = "credit_amount", precision = 19, scale = 2)
    open var creditAmount: BigDecimal? = null

    @Enumerated(value = EnumType.STRING)
    open var gender: Gender? = null

    @Lob
    @Column(name = "avatar")
    open var avatar: ByteArray? = null

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "credentials_id")
    open var credentials: Credentials? = null
}