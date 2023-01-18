package com.sanskar.theater.booking

import com.sanskar.theater.model.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository: JpaRepository<Seat, Long>