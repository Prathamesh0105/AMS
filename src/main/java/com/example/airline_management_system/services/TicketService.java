package com.example.airline_management_system.services;

import com.example.airline_management_system.data.Ticket;
import com.example.airline_management_system.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket getTicket(Long ticketId) {
        return ticketRepository.getTicket(ticketId);
    }

    public Ticket bookTicket(Ticket ticketDetails) {
        return ticketRepository.bookTicket(ticketDetails);
    }

    public boolean cancelTicket(Long ticketId) {
        return ticketRepository.cancelTicket(ticketId);
    }
}
