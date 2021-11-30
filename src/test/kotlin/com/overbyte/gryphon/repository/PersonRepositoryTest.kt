package com.overbyte.gryphon.repository

import com.overbyte.gryphon.generator.PersonGenerator
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    lateinit var personRepository: PersonRepository

    @Test
    fun `should be able to save a person entity`() {
        val person = PersonGenerator.next()
        personRepository.save(person)
        assertNotNull(person.id)
    }
}