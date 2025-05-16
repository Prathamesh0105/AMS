package com.example.airline_management_system.services;

import com.example.airline_management_system.data.Flight;
import com.example.airline_management_system.data.Schedule;
import com.example.airline_management_system.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(String sort) {
        return flightRepository.getAllFlights(sort);
    }

    public Flight getOneFlight(Long flightId) {
        return flightRepository.getOneFlight(flightId);
    }

    public List<Schedule> getSchedule(Long flightId, LocalDate date) {
        return flightRepository.getSchedule(flightId, date);
    }
}
