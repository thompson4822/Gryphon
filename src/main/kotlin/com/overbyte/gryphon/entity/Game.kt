package com.overbyte.gryphon.entity

import javax.persistence.Column
import javax.persistence.Entity

@Entity
open class Game : Product() {
    @Column(name = "min_payers")
    open var minPayers: Int? = null

    @Column(name = "max_players")
    open var maxPlayers: Int? = null

    @Column(name = "min_play_time")
    open var minPlayTime: Int? = null

    @Column(name = "max_play_time")
    open var maxPlayTime: Int? = null

    @Column(name = "min_age")
    open var minAge: Int? = null
}