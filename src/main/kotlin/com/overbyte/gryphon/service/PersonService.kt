package com.overbyte.gryphon.service

import com.overbyte.gryphon.conversion.toDto
import com.overbyte.gryphon.conversion.toEntity
import com.overbyte.gryphon.dto.PersonDto
import com.overbyte.gryphon.dto.PersonResponseDto
import com.overbyte.gryphon.entity.Person
import com.overbyte.gryphon.exception.ResourceNotFoundException
import com.overbyte.gryphon.repository.PersonRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

interface PersonService {
    fun createPerson(person: PersonDto): PersonDto
    fun getPeople(pageNo: Int, pageSize: Int, sortBy: String, sortDir: String): PersonResponseDto
    fun getPersonById(personId: Long): PersonDto
    fun updatePerson(person: PersonDto, personId: Long): PersonDto
    fun deleteById(personId: Long): Unit
}

@Service
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {
    override fun createPerson(person: PersonDto): PersonDto {
        val newPerson = personRepository.save(person.toEntity())
        return newPerson.toDto()
    }

    override fun getPeople(pageNo: Int, pageSize: Int, sortBy: String, sortDir: String): PersonResponseDto {
        var sort = Sort.by(sortBy)
        sort = if(sortDir == "asc") sort.ascending() else sort.descending()
        val pageable = PageRequest.of(pageNo, pageSize, sort)
        val people = personRepository.findAll(pageable)
        return PersonResponseDto(
            people.number, people.size, people.totalElements,
            people.totalPages, people.isLast, people.sort.toString(),
            people.content.map { it.toDto() })

    }

    override fun getPersonById(personId: Long): PersonDto =
        safeFindById(personId).toDto()

    override fun updatePerson(person: PersonDto, personId: Long): PersonDto {
        val existing = safeFindById(personId)
        existing.apply {
            avatar = person.avatar
            gender = person.gender
            address = person.address?.toEntity()
            firstName = person.firstName
            lastName = person.lastName
            credentials = person.credentials?.toEntity()
            creditAmount = person.creditAmount
            email = person.email
        }
        val updated = personRepository.save(existing)
        return updated.toDto()
    }

    override fun deleteById(personId: Long) {
        val existing = safeFindById(personId)
        personRepository.delete(existing)
    }

    private fun safeFindById(id: Long): Person =
        personRepository.findById(id).orElseThrow { ->
            ResourceNotFoundException("Person", "id", id)
        }

}