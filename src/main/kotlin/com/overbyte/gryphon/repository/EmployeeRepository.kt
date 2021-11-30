package com.overbyte.gryphon.repository;

import com.overbyte.gryphon.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long> {
    fun findEmployeeByStoreId(storeId: Long): List<Employee>?
}