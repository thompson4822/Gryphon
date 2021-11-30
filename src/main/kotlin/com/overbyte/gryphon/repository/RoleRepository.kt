package com.overbyte.gryphon.repository;

import com.overbyte.gryphon.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
}