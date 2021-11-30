package com.overbyte.gryphon.service

import com.overbyte.gryphon.enumerations.Gender
import com.overbyte.gryphon.enumerations.StateAbbreviation
import org.springframework.stereotype.Service

interface ConstantService {
    fun getGenders(): List<String>?
    fun getStates(): List<String>?

}

@Service
class ConstantServiceImpl : ConstantService {
    override fun getGenders(): List<String>? {
        return Gender.values().map { it.name }
    }

    override fun getStates(): List<String>? {
        return StateAbbreviation.values().map { it.name }
    }

}