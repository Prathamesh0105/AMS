package com.example.airline_management_system.repository;

import com.example.airline_management_system.data.Flight;
import com.example.airline_management_system.data.Schedule;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class FlightRepository {
    private Map<Long, Flight> flightTable;
    private Map<Long, List<Schedule>> scheduleTable;

    @PostConstruct
    public void init() {
        flightTable = new HashMap<>();
        scheduleTable = new HashMap<>();
    }

    // 1️⃣ Get all flights with sorting (asc or dsc)
    public List<Flight> getAllFlights(String sort) {
        return flightTable.values()
                .stream()
                .sorted(Comparator.comparing(Flight::getId,
                        "asc".equalsIgnoreCase(sort) ? Comparator.naturalOrder() : Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    // 2️⃣ Get a single flight by ID (without schedules)
    public Flight getOneFlight(Long flightId) {
        return flightTable.get(flightId);
    }

    // 3️⃣ Get schedules for a flight on a specific date
    public List<Schedule> getSchedule(Long flightId, LocalDate date) {
        return scheduleTable.getOrDefault(flightId, Collections.emptyList())
                .stream()
                .filter(schedule -> schedule.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
