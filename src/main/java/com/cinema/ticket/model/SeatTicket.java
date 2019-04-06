package com.cinema.ticket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatTicket {

    private Integer screen;

    private LocalDateTime start;

    private Integer seatNumber;

}
