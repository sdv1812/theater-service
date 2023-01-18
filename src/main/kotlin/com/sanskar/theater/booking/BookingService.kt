package com.sanskar.theater.booking

import com.sanskar.theater.model.Booking
import com.sanskar.theater.model.Performance
import com.sanskar.theater.model.Seat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookingService {

    @Autowired
    lateinit var bookingRepository: BookingRepository

    @Autowired
    lateinit var seatRepository: SeatRepository

    fun isSeatFree(seat: Seat, performance: Performance): Boolean {
        return null == findBooking(seat, performance)
    }

    fun findSeat(seatNum: Int, seatRow: Char): Seat? {
        val allSeats = seatRepository.findAll()
        return allSeats.firstOrNull { it.num == seatNum && it.rowNum == seatRow }

    }

    fun findBooking(seat: Seat, performance: Performance): Booking? {
        val allBookings = bookingRepository.findAll()
        return allBookings.firstOrNull { it.seat == seat && it.performance == performance }
    }

    fun reserveSeat(seat: Seat, performance: Performance, customerName: String): Booking {
        val booking = Booking(0, customerName)
        booking.seat = seat
        booking.performance = performance
        return bookingRepository.save(booking)
    }
}