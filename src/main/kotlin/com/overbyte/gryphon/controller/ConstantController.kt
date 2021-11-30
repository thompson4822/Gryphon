package com.overbyte.gryphon.controller

import com.overbyte.gryphon.service.ConstantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/constant")
class ConstantController(private val constantService: ConstantService) {
    @GetMapping("/genders")
    fun getGenders(): ResponseEntity<List<String>> =
        ResponseEntity.ok(constantService.getGenders())

    @GetMapping("/states")
    fun getStates(): ResponseEntity<List<String>> =
        ResponseEntity.ok(constantService.getStates())
}