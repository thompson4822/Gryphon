package com.overbyte.gryphon.entity

import javax.persistence.*

@Table(name = "rental_feedback")
@Entity
open class RentalFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "rental_id", nullable = false)
    open var rental: Rental? = null

    @Column(name = "rating", nullable = false)
    open var rating: Int? = null

    @Column(name = "other")
    open var other: String? = null
}