package com.overbyte.gryphon.service

import com.overbyte.gryphon.dto.ProductCountDto
import com.overbyte.gryphon.repository.InventoryItemRepository
import org.springframework.stereotype.Service

interface InventoryItemService {
    fun findProductsInStore(storeId: Long): List<ProductCountDto>
}

@Service
class InventoryItemServiceImpl(private val inventoryItemRepository: InventoryItemRepository) : InventoryItemService {
    override fun findProductsInStore(storeId: Long): List<ProductCountDto> =
        inventoryItemRepository.findProductCountInStore(storeId)


}