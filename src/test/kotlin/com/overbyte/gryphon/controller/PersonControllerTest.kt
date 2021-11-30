package com.overbyte.gryphon.controller

import com.overbyte.gryphon.conversion.toDto
import com.overbyte.gryphon.dto.PersonResponseDto
import com.overbyte.gryphon.generator.PersonGenerator
import com.overbyte.gryphon.service.PersonService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
internal class PersonControllerTest {
    // This is necessary to use mockk
    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun personService() = mockk<PersonService>()
    }

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var personService: PersonService

    private val mockPerson = PersonGenerator.next()

    private val mockEntity = PersonResponseDto(1, 1, 1, 1,
        true, "asc", listOf(mockPerson.toDto()))

    @Test
    fun `should return a page of people`() {
        every { personService.getPeople(any(), any(), any(), any()) } returns mockEntity
        // When
        val result = mockMvc.get("/api/person?pageNo=1&pageSize=1")
            .andDo { print() }

        // Then
        result.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$.pageNo") {value("1")}
            jsonPath("$.pageSize") {value("1")}
            jsonPath("$.totalElements") {value("1")}
            jsonPath("$.totalPages") {value("1")}
            jsonPath("$.last") {value("true")}
            jsonPath("$.sortBy") {value("asc")}
            jsonPath("$.content[0].firstName") {value(mockPerson.firstName)}
            jsonPath("$.content[0].lastName") {value(mockPerson.lastName)}
        }
    }
}
