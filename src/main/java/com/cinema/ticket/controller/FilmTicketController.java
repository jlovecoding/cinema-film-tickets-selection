package com.cinema.ticket.controller;

import com.cinema.ticket.model.FilmTicket;
import com.cinema.ticket.service.FilmTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets/films")
public class FilmTicketController {

    @Autowired
    private FilmTicketService filmTicketService;

    @GetMapping
    public List<FilmTicket> findFilms() {
        return filmTicketService.findFilms();
    }

    @GetMapping("/{title}")
    public List<FilmTicket> findFilmStartTimes(@PathVariable final String title) {
        return filmTicketService.findFilmStartTimes(title);
    }
}
