package com.overbyte.gryphon.service

import com.overbyte.gryphon.conversion.toDto
import com.overbyte.gryphon.entity.Person
import com.overbyte.gryphon.exception.ResourceNotFoundException
import com.overbyte.gryphon.generator.PersonGenerator
import com.overbyte.gryphon.repository.PersonRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

internal class PersonServiceImplTest {
    private val personRepository: PersonRepository = mockk()
    private val personService = PersonServiceImpl(personRepository)

    @Test
    fun `should call data source to delete people`() {
        // Given
        val person = PersonGenerator.next()
        every { personRepository.findById(any()) } returns Optional.of(person)
        every { personRepository.delete(person) } returns Unit
        // When
        personService.deleteById(1)
        // Then
        verify(exactly = 1) { personRepository.findById(any()) }
        verify(exactly = 1) { personRepository.delete(person) }
    }

    @Test
    fun `should generate exception when trying to delete unknown people`() {
        // Given
        val personId = 1L
        every { personRepository.findById(personId) } returns Optional.empty()
        // When
        val exception = assertThrows(ResourceNotFoundException::class.java) {
            personService.deleteById(personId)
        }
        // Then
        assertEquals("Person not found with id : $personId", exception.message)
    }

    @Test
    fun `should call its data source to update people`() {
        // Given
        val person = PersonGenerator.next()
        val personDto = person.toDto()
        val personId = 1L
        every { personRepository.findById(personId) } returns Optional.of(person)
        every { personRepository.save(person) } returns person
        // When
        val updatedPerson = personService.updatePerson(personDto, personId)
        // Then
        verify(exactly = 1) { personRepository.findById(personId) }
        verify(exactly = 1) { personRepository.save(person) }
        assertThat(updatedPerson).isEqualTo(personDto)
    }

    @Test
    fun `should call its data source to retrieve people`() {
        // given
        every { personRepository.findAll(ofType(Pageable::class)) } returns buildPage()

        // when
        val people = personService.getPeople(1, 10, "firstName", "asc")

        // then
        verify(exactly = 1) { personRepository.findAll(ofType(Pageable::class)) }
    }

    private val people = listOf(PersonGenerator.next(), PersonGenerator.next())

    private fun buildPage(): Page<Person> {
        return PageImpl<Person>(people)
    }

}