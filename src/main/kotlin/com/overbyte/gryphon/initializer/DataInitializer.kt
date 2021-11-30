package com.overbyte.gryphon.initializer

import com.overbyte.gryphon.entity.InventoryItem
import com.overbyte.gryphon.generator.*
import com.overbyte.gryphon.repository.*
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.random.Random

@Configuration
class DataInitializer {
    private val random: Random = Random(System.currentTimeMillis())

    @Bean
    fun initializer(personRepository: PersonRepository,
                    storeRepository: StoreRepository,
                    roleRepository: RoleRepository,
                    employeeRepository: EmployeeRepository,
                    productRepository: ProductRepository,
                    inventoryItemRepository: InventoryItemRepository
    ): ApplicationRunner? {
        return ApplicationRunner { args: ApplicationArguments? ->
            if (personRepository.count() == 0L) {
                // Generate 200 Person entities
                val people = (0..200).map { PersonGenerator.next() }

                // Write Person entities to the DB
                personRepository.saveAll(people)

                val roles = roleRepository.findAll()

                // Generate 20 Store entities
                val stores = (0..20).map { StoreGenerator.next() }

                // Write Store entities to the DB
                storeRepository.saveAll(stores)

                // Save all the products
                val products = ProductGenerator.products
                productRepository.saveAll(products)

                // Generate inventory for the various stores
                val inventoryItems = stores.map { currentStore ->
                    (1 .. 200).map { InventoryItemGenerator.next(currentStore, products) }
                }.flatten()

                // Write all inventory to the DB
                inventoryItemRepository.saveAll(inventoryItems)

                // Add employees to the store
                val storeEmployees = stores.map { store ->
                    (0 .. random.nextInt(3, 5)).map {
                        EmployeeGenerator.next(roles, store)
                    }
                }.flatten()

                // Write all employee persons to the DB
                personRepository.saveAll(storeEmployees.map { it.person })

                // Write all employees to the DB
                employeeRepository.saveAll(storeEmployees)
            }
        }
    }
}