package com.sanskar.theater.model

import com.google.gson.annotations.Expose
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class Booking(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Expose
    val id: Long,
    @Expose
    val customerName: String
) {
    @ManyToOne
    lateinit var seat: Seat
    @ManyToOne
    lateinit var performance: Performance
}
