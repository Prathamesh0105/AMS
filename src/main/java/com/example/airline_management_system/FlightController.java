package com.example.airline_management_system;

import com.example.airline_management_system.data.Flight;
import com.example.airline_management_system.data.Schedule;
import com.example.airline_management_system.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping()
    public List<Flight> getAllFlights(@RequestParam(defaultValue = "asc") String sort) {
        return flightService.getAllFlights(sort);
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getOneFlight(id);
    }

    @GetMapping("/{id}/schedules")
    public List<Schedule> getSchedule(@PathVariable Long id, @RequestParam LocalDate dates) {
        return flightService.getSchedule(id, dates);
    }
}
