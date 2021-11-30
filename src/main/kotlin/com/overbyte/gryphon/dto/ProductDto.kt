package com.overbyte.gryphon.dto

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.overbyte.gryphon.entity.InventoryItem
import com.overbyte.gryphon.entity.Store
import java.math.BigDecimal
import javax.persistence.*

data class ProductDto(
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    val publisher: String? = null,
    val baseCost: BigDecimal? = null,
    val image: ByteArray? = null,
)
