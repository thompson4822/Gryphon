package com.overbyte.gryphon.controller

import com.overbyte.gryphon.dto.ProductCountDto
import com.overbyte.gryphon.entity.Store
import com.overbyte.gryphon.service.InventoryItemService
import com.overbyte.gryphon.service.StoreService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/store")
class StoreController(
    private val storeService: StoreService,
    private val inventoryItemService: InventoryItemService) {

    @GetMapping
    fun getAllStores(): ResponseEntity<List<Store>> {
        val stores = storeService.getAllStores()
        return ResponseEntity.ok(stores)
    }

    @GetMapping("/{storeId}/products")
    fun getProductsInStore(@PathVariable storeId: Long): ResponseEntity<List<ProductCountDto>> =
        ResponseEntity.ok(inventoryItemService.findProductsInStore(storeId))


}