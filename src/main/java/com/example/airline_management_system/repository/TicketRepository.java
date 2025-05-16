package com.example.airline_management_system.repository;

import com.example.airline_management_system.data.Ticket;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TicketRepository {
    private Map<Long, Ticket> ticketTable;

    @PostConstruct
    public void init() {
        ticketTable = new HashMap<>();
    }

    // 1️⃣ Get a ticket by ID
    public Ticket getTicket(Long ticketId) {
        return ticketTable.get(ticketId);
    }

    // 2️⃣ Book a new ticket
    public Ticket bookTicket(Ticket ticketDetails) {
        Long ticketId = generateUniqueTicketId();
        String bookingReference = "REF-" + UUID.randomUUID().toString().substring(0, 8); // Unique reference

        Ticket newTicket = ticketDetails.toBuilder()
                .id(ticketId)
                .bookingReference(bookingReference)
                .build();

        ticketTable.put(ticketId, newTicket);
        return newTicket;
    }

    // 3️⃣ Cancel a ticket
    public boolean cancelTicket(Long ticketId) {
        if (ticketTable.containsKey(ticketId)) {
            ticketTable.remove(ticketId);
            return true;
        }
        return false;
    }

    // Utility function to generate a unique ticket ID
    private Long generateUniqueTicketId() {
        return ticketTable.keySet().stream()
                .max(Long::compareTo)
                .orElse(0L) + 1;
    }
}
