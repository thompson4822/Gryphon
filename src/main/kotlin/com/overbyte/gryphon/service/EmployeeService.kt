package com.overbyte.gryphon.service

import com.overbyte.gryphon.dto.EmployeeDto
import com.overbyte.gryphon.entity.Employee
import com.overbyte.gryphon.repository.EmployeeRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

interface EmployeeService {
    fun getEmployees(storeId: Long): List<EmployeeDto>?
}

@Service
class EmployeeServiceImpl(private val employeeRepository: EmployeeRepository) : EmployeeService {
    override fun getEmployees(storeId: Long): List<EmployeeDto>? =
        employeeRepository.findEmployeeByStoreId(storeId)?.map {
            EmployeeDto(it.id, it.ssn, it.hireDate, it.exitDate,
                it.person, it.role, it.hourlyRate)
        }


}

