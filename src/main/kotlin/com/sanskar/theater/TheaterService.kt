package com.sanskar.theater

import com.sanskar.theater.model.Seat
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TheaterService {

    private val hiddenSeats = mutableListOf<Seat>()

    init {
        fun getPrice(row: Char, num: Int) : BigDecimal {
            return when {
                row >='M' -> BigDecimal(14.50)
                num <=3 || num >= 34 -> BigDecimal(16.50)
                row == 'A' -> BigDecimal(21)
                else -> BigDecimal(18)
            }

        }

        fun getDescription(row: Char, num: Int) : String {
            return when {
                row == 'O' -> "Back Row"
                row == 'N' -> "Cheaper Seat"
                num <= 3 || num >= 34 -> "Restricted View"
                row <= 'B' -> "Best View"
                else -> "Standard Seat"
            }
        }
        for (row in 'A'..'O') {
            for (num in 1..36) {
                hiddenSeats.add(Seat(0, row, num, getPrice(row,num), getDescription(row,num) ))
            }
        }
    }

	val seats
    get() = hiddenSeats.toList()

    fun find(num: Int, row: Char): Seat {
        return seats.first { it.rowNum == row && it.num == num }
    }

}
