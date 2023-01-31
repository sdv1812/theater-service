package com.sanskar.theater

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class TheaterApplication

fun main(args: Array<String>) {
	runApplication<TheaterApplication>(*args)
}
