package com.overbyte.gryphon.service

import com.overbyte.gryphon.dto.ProductDto
import com.overbyte.gryphon.repository.ProductRepository
import org.springframework.stereotype.Service

interface ProductService {
    fun productsAtStore(storeId: Long): List<ProductDto>?
}

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {
    override fun productsAtStore(storeId: Long): List<ProductDto>? {
        return listOf<ProductDto>()
    }

}