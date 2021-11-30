package com.overbyte.gryphon.dto

import com.overbyte.gryphon.entity.Person

data class PersonResponseDto(
    val pageNo: Int,
    val pageSize: Int,
    val totalElements: Long,
    val totalPages: Int,
    val last: Boolean,
    val sortBy: String,
    val content: List<PersonDto> = listOf(),

    ) {
}