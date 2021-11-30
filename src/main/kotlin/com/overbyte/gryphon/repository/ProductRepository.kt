package com.overbyte.gryphon.repository;

import com.overbyte.gryphon.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
//    fun getProductsByInventoryItemsContaining
}