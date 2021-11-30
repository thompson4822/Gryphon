package com.overbyte.gryphon.service

import com.overbyte.gryphon.entity.Store
import com.overbyte.gryphon.repository.StoreRepository
import org.springframework.stereotype.Service

interface StoreService {
    fun getAllStores(): List<Store>?

}

@Service
class StoreServiceImpl(private val storeRepository: StoreRepository): StoreService {
    override fun getAllStores(): List<Store>? =
        storeRepository.findAll()

}