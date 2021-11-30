package com.overbyte.gryphon.dto

import com.overbyte.gryphon.enumerations.StateAbbreviation
import javax.persistence.Column

data class AddressDto(
    val addressLine1: String?,
    val addressLine2: String?,
    val city: String?,
    val state: StateAbbreviation?,
    val zipCode: String?
)
