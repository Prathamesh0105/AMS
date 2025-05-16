package com.example.airline_management_system.data;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder(toBuilder = true)
public class Schedule {
    private Long id;
    private Long flightId;
    private LocalDate date;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int availableSeats;
}
