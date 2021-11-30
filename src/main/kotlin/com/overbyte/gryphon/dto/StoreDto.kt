package com.overbyte.gryphon.dto

import java.math.BigDecimal

data class StoreDto (
    val id: Long?,
    val address: AddressDto?,
    val phone: String?,
    val email: String?,
    val website: String?,
    val tax: BigDecimal?,
    val image: ByteArray?
)