package com.overbyte.gryphon.repository;

import com.overbyte.gryphon.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {

}