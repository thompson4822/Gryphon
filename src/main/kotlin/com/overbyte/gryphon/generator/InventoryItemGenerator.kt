package com.overbyte.gryphon.generator

import com.overbyte.gryphon.entity.InventoryItem
import com.overbyte.gryphon.entity.Product
import com.overbyte.gryphon.entity.Store
import kotlin.random.Random

object InventoryItemGenerator {
    private val random = Random(System.currentTimeMillis())
    private var initialBarCode = 100000000L

    fun next(currentStore: Store, products: List<Product>): InventoryItem =
        InventoryItem().apply {
            store = currentStore
            product = products[random.nextInt(products.count())]
            barcode = nextBarcode()
        }

    private fun nextBarcode(): String {
        initialBarCode += 1
        return "$initialBarCode"
    }
}