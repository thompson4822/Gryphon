package com.overbyte.gryphon.generator

import com.overbyte.gryphon.entity.Store
import java.io.File
import java.math.BigDecimal
import kotlin.random.Random
import kotlin.random.nextLong

object StoreGenerator {
    private val random = Random(System.currentTimeMillis())

    fun next(): Store =
        Store().apply {
            address = AddressGenerator.next()
            tax = nextTax
            email = "store${random.nextInt(100, 900)}@gryphon.com"
            phone = "${random.nextLong(1000000000L .. 9999999999L)}"
            image = nextStoreImage
        }


    // Could potentially be computed in a different way later
    val nextTax: BigDecimal
        get() = BigDecimal(0.05)

    private val nextStoreImage: ByteArray
        get() = storeFronts[random.nextInt(storeFronts.count())]

    private val storeFronts = getStoreFronts()

    private fun getStoreFronts(): List<ByteArray> {
        val path = File("images/store/")
        val allFiles = path.listFiles()
        return allFiles.map { file ->
            file.readBytes()
        }
    }

}