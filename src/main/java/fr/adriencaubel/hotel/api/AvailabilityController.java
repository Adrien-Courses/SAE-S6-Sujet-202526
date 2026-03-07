package fr.adriencaubel.hotel.api;

import fr.adriencaubel.hotel.api.dto.AvailabilityResponse;
import fr.adriencaubel.hotel.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    
    private final HotelService hotelService;
    
    public AvailabilityController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    
    @GetMapping
    public AvailabilityResponse check(@RequestParam Long roomTypeId,
                                      @RequestParam LocalDate from,
                                      @RequestParam LocalDate to,
                                      @RequestParam(defaultValue = "1") int qty) {
        return hotelService.checkAvailability(roomTypeId, from, to, qty);
    }
}
