package com.overbyte.gryphon.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Table(name = "credentials")
@Entity
open class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @NotEmpty(message = "User name cannot be empty")
    @NotNull(message = "User name cannot be null")
    @Column(name = "username", nullable = false, unique = true)
    open var username: String? = null

    @NotEmpty(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
    @Column(name = "password", nullable = false)
    open var password: String? = null
}