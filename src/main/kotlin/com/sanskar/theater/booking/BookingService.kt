package com.sanskar.theater.booking

import com.sanskar.theater.model.Seat
import org.springframework.stereotype.Service

@Service
class BookingService {

    fun isSeatFree(seat: Seat): Boolean {
        return true
    }
}