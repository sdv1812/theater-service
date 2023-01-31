package com.sanskar.theater.model

import com.google.gson.annotations.Expose
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Performance(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Expose
    val id: Long,
    @Expose
    val title: String,
) {
    @OneToMany(mappedBy = "performance")
    lateinit var bookings: List<Booking>
}
