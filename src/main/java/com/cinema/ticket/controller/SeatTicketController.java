package com.cinema.ticket.controller;

import com.cinema.ticket.model.SeatTicket;
import com.cinema.ticket.service.SeatTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@RestController
@RequestMapping("/tickets/seats")
public class SeatTicketController {

    @Autowired
    private SeatTicketService seatTicketService;

    @GetMapping("/screen/{screen}/start/{start}")
    public List<SeatTicket> findAvailableSeatsByScreenAndStartTime(
            @PathVariable final Integer screen,
            @PathVariable @DateTimeFormat(iso = DATE_TIME) final LocalDateTime start) {
        return seatTicketService.findAvailableSeatsByScreenAndStartTime(screen, start);
    }
}
