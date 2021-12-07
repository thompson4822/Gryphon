package com.overbyte.gryphon.repository;

import com.overbyte.gryphon.repository.mapper.StoreProductCount
import com.overbyte.gryphon.entity.InventoryItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface InventoryItemRepository : JpaRepository<InventoryItem, Long> {
    @Query("SELECT II.product.id as id, COUNT(II.id) as units FROM InventoryItem II WHERE II.store.id = ?1 GROUP BY II.product.id")
    fun findProductCountInStore(storeId: Long): List<StoreProductCount>


}