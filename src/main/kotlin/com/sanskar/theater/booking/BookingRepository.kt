package com.sanskar.theater.booking

import com.sanskar.theater.model.Booking
import org.springframework.data.jpa.repository.JpaRepository

interface BookingRepository: JpaRepository<Booking, Long>