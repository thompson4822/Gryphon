package com.overbyte.gryphon.conversion

import com.overbyte.gryphon.dto.AddressDto
import com.overbyte.gryphon.dto.CredentialsDto
import com.overbyte.gryphon.dto.PersonDto
import com.overbyte.gryphon.dto.StoreDto
import com.overbyte.gryphon.entity.Address
import com.overbyte.gryphon.entity.Credentials
import com.overbyte.gryphon.entity.Person
import com.overbyte.gryphon.entity.Store

fun Person.toDto() =
    PersonDto(id, firstName, lastName, phone, address?.toDto(),
        creditAmount, gender, avatar, credentials?.toDto(), email)

fun PersonDto.toEntity(): Person {
    val person = Person()
    person.id = id
    person.firstName = firstName
    person.lastName = lastName
    person.phone = phone
    person.address = address?.toEntity()
    person.creditAmount = creditAmount
    person.gender = gender
    person.avatar = avatar
    person.credentials = credentials?.toEntity()
    person.email = email
    return person
}

fun Credentials.toDto() =
    CredentialsDto(id, username, password)

fun CredentialsDto.toEntity(): Credentials {
    val creds = Credentials()
    creds.id = id
    creds.username = username
    creds.password = password
    return creds
}

fun Address.toDto() =
    AddressDto(addressLine1, addressLine2, city, state, zipCode)

fun AddressDto.toEntity(): Address {
    val address = Address()
    address.addressLine1 = addressLine1
    address.addressLine2 = addressLine2
    address.city = city
    address.state = state
    address.zipCode = zipCode
    return address
}

fun Store.toDto() =
    StoreDto(id, address?.toDto(), phone, email, website, tax, image)

fun StoreDto.toEntity(): Store {
    val store = Store()
    store.id = id
    store.address = address?.toEntity()
    store.phone = phone
    store.email = email
    store.website = website
    store.tax = tax
    store.image = image
    return store
}