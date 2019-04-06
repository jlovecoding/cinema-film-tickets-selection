package com.cinema.ticket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
@Data
@Builder
public class FilmTicket {

    private String title;

    private Integer screen;

    private LocalDateTime start;

}
