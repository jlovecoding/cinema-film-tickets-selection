package com.cinema.ticket.service.seat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatServiceClientResponse {

    private Integer screen;

    private LocalDateTime start;

    private Integer seatNumber;

    private Boolean available;

}
