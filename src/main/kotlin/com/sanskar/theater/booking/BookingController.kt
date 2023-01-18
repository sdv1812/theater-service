package com.sanskar.theater.booking

import com.sanskar.theater.TheaterService
import com.sanskar.theater.model.Booking
import com.sanskar.theater.model.Performance
import com.sanskar.theater.model.Seat
import com.sanskar.theater.performance.PerformanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class BookingController {

    @Autowired
    lateinit var theaterService: TheaterService

    @Autowired
    lateinit var bookingService: BookingService

    @Autowired
    lateinit var seatRepository: SeatRepository

    @Autowired
    lateinit var performanceRepository: PerformanceRepository

    @RequestMapping("/")
    fun homePage(): ModelAndView {
        val model = mapOf("bean" to CheckAvailabilityBackingBean(),
            "performances" to performanceRepository.findAll(),
            "seatNums" to 1..36,
            "seatRows" to 'A'..'O' )

        return ModelAndView("seatBooking", model)
    }

    @RequestMapping(value = ["/checkAvailability"], method = [RequestMethod.POST])
    fun checkAvailability(bean: CheckAvailabilityBackingBean): ModelAndView {
        val selectedSeat: Seat = bookingService.findSeat(bean.selectedSeatNum, bean.selectedSeatRow)!!
        val selectedPerformance: Performance = performanceRepository.findById(bean.selectedPerformance!!).get()
        val result = bookingService.isSeatFree(selectedSeat, selectedPerformance)
        bean.performance = selectedPerformance
        bean.seat = selectedSeat
        bean.available = result
        if (!result) {
            bean.booking = bookingService.findBooking(selectedSeat, selectedPerformance)
        }
        return ModelAndView("seatBooking", mapOf("bean" to bean,
            "performances" to performanceRepository.findAll(),
            "seatNums" to 1..36,
            "seatRows" to 'A'..'O'))
    }

    @RequestMapping(value=["booking"], method = arrayOf(RequestMethod.POST))
    fun bookASeat(bean: CheckAvailabilityBackingBean): ModelAndView {
        val booking: Booking = bookingService.reserveSeat(bean.seat!!, bean.performance!!, bean.customerName)
        return ModelAndView("bookingConfirmed", "booking", booking)
    }

    @RequestMapping("bootstrap")
    fun createInitialData(): ModelAndView {
        val seats = theaterService.seats
        seatRepository.saveAll(seats)
        return homePage()
    }

}

class CheckAvailabilityBackingBean {
    var selectedSeatNum = 1
    var selectedSeatRow = 'A'
    var selectedPerformance: Long? = null
    var customerName: String = ""
    var available: Boolean? = null
    var seat: Seat? = null
    var performance: Performance? = null
    var booking: Booking? = null
}