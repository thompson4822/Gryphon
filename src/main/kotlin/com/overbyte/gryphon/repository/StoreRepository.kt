package com.overbyte.gryphon.repository;

import com.overbyte.gryphon.entity.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository : JpaRepository<Store, Long> {
}