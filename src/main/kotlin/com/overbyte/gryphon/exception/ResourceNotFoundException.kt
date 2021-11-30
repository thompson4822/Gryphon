package com.overbyte.gryphon.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException(
    private val resourceName: String,
    private val fieldName: String,
    private val fieldValue: Long) :
    RuntimeException("$resourceName not found with $fieldName : $fieldValue")

