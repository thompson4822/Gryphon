package com.overbyte.gryphon.controller

import com.overbyte.gryphon.dto.ProductCountDto
import com.overbyte.gryphon.service.InventoryItemService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/store/{storeId}/product")
class ProductsController(private val inventoryItemService: InventoryItemService) {
    @GetMapping
    fun getProducts(@PathVariable storeId: Long): ResponseEntity<List<ProductCountDto>> =
        ResponseEntity.ok(inventoryItemService.findProductsInStore(storeId))
}