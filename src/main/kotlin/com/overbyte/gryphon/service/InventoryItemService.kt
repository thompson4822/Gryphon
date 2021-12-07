package com.overbyte.gryphon.service

import com.overbyte.gryphon.conversion.toDto
import com.overbyte.gryphon.dto.ProductCountDto
import com.overbyte.gryphon.exception.ResourceNotFoundException
import com.overbyte.gryphon.repository.InventoryItemRepository
import com.overbyte.gryphon.repository.ProductRepository
import com.overbyte.gryphon.repository.StoreRepository
import org.springframework.stereotype.Service

interface InventoryItemService {
    fun findProductsInStore(storeId: Long): List<ProductCountDto>
}

@Service
class InventoryItemServiceImpl(private val inventoryItemRepository: InventoryItemRepository,
                               private val storeRepository: StoreRepository,
                               private val productRepository: ProductRepository) : InventoryItemService {
    override fun findProductsInStore(storeId: Long): List<ProductCountDto> {
        val store = storeRepository.findById(storeId).orElseThrow { -> ResourceNotFoundException("Store", "id", storeId)}
        return inventoryItemRepository.findProductCountInStore(storeId).map { storeProduct ->
            val product = productRepository.findById(storeProduct.id).get()
            ProductCountDto(product.toDto(), storeProduct.units)
        }.sortedBy { it.product?.name }
    }



}