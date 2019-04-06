package com.cinema.ticket.service;

import com.cinema.ticket.model.FilmTicket;
import com.cinema.ticket.service.film.FilmServiceClient;
import com.cinema.ticket.service.film.FilmServiceClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FilmTicketService {

    @Autowired
    private FilmServiceClient filmServiceClient;

    public List<FilmTicket> findFilms() {
        return filmServiceClient.findAll(null).stream()
                .map(FilmTicketService::toFilmTicket)
                .collect(toList());
    }

    public List<FilmTicket> findFilmStartTimes(final String title) {
        return filmServiceClient.findAll(title).stream()
                .map(FilmTicketService::toFilmTicket)
                .collect(toList());
    }

    private static FilmTicket toFilmTicket(FilmServiceClientResponse filmServiceClientResponse) {
        return FilmTicket.builder()
                .title(filmServiceClientResponse.getTitle())
                .screen(filmServiceClientResponse.getScreen())
                .start((filmServiceClientResponse.getStart()))
                .build();
    }
}
