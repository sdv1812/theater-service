package com.sanskar.theater.model

import com.google.gson.annotations.Expose
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Seat(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Expose
    val id: Long,
    @Expose val rowNum: Char,
    @Expose val num: Int,
    @Expose val price: BigDecimal,
    @Expose val description: String) {
    override fun toString(): String = "Seat $rowNum-$num $$price ($description)"
}