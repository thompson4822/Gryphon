package com.overbyte.gryphon.controller

import com.overbyte.gryphon.dto.PersonResponseDto
import com.overbyte.gryphon.entity.Person
import com.overbyte.gryphon.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/api/person")
class PersonController(private val personService: PersonService) {
    @GetMapping
    fun getPeople(
        @RequestParam(value = "pageNo", defaultValue = "0", required = false) pageNo: Int,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) pageSize: Int,
        @RequestParam(value = "sortBy", defaultValue = "id", required = false) sortBy: String,
        @RequestParam(value = "sortDir", defaultValue = "asc", required = false) sortDir: String,
    ): ResponseEntity<PersonResponseDto> =
        ResponseEntity.ok(personService.getPeople(pageNo, pageSize, sortBy, sortDir))

    /*
    Add the following:
    - Update
    - Add
    - Delete
     */
}