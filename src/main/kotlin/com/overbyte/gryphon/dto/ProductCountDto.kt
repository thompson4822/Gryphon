package com.overbyte.gryphon.dto

import com.overbyte.gryphon.entity.Product
import com.overbyte.gryphon.entity.Store

data class ProductCountDto(
    val product: ProductDto?,
    val units: Int?,
)