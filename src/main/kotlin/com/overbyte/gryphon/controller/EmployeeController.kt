package com.overbyte.gryphon.controller

import com.overbyte.gryphon.dto.EmployeeDto
import com.overbyte.gryphon.entity.Employee
import com.overbyte.gryphon.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/store/{storeId}/employee")
class EmployeeController(private val employeeService: EmployeeService) {
    @GetMapping
    fun getEmployeesByStore(@PathVariable storeId: Long): ResponseEntity<List<EmployeeDto>> {
        val employees = employeeService.getEmployees(storeId)
        return ResponseEntity.ok(employees)
    }

}