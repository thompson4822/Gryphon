package com.overbyte.gryphon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GryphonApplication

fun main(args: Array<String>) {
    runApplication<GryphonApplication>(*args)
}
