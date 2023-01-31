package com.sanskar.theater.reporting

import com.sanskar.theater.booking.BookingRepository
import com.sanskar.theater.model.Booking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ReportsService {

    @Autowired
    lateinit var bookingRepository: BookingRepository

    fun allBookings() : List<Booking> {
        return bookingRepository.findAll()
    }

    fun premiumBookings() : List<Booking> {
        val bookings = bookingRepository.findAll()
        return bookings
                .filter {it.seat.price > BigDecimal(15) }
    }

}