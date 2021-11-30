package com.overbyte.gryphon.dto

import com.overbyte.gryphon.entity.Address
import com.overbyte.gryphon.entity.Credentials
import com.overbyte.gryphon.enumerations.Gender
import java.math.BigDecimal

data class PersonDto(
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    val phone: String?,
    val address: AddressDto?,
    val creditAmount: BigDecimal?,
    val gender: Gender?,
    val avatar: ByteArray?,
    val credentials: CredentialsDto?,
    val email: String?
) {

}
