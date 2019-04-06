package com.cinema.ticket.service;

import com.cinema.ticket.model.SeatTicket;
import com.cinema.ticket.service.seat.SeatServiceClient;
import com.cinema.ticket.service.seat.SeatServiceClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class SeatTicketService {

    @Autowired
    private SeatServiceClient seatServiceClient;

    public List<SeatTicket> findAvailableSeatsByScreenAndStartTime(final Integer screen, final LocalDateTime start) {
        return findAvailableSeats(screen, start).stream()
                .map(SeatTicketService::toSeatTicket)
                .collect(toList());
    }

    private List<SeatServiceClientResponse> findAvailableSeats(Integer screen, LocalDateTime start) {
        return seatServiceClient.findByScreenAndStartAndAvailable(screen, start, true);
    }

    private static SeatTicket toSeatTicket(SeatServiceClientResponse seatServiceClientResponse) {
        return SeatTicket.builder()
                .screen(seatServiceClientResponse.getScreen())
                .start(seatServiceClientResponse.getStart())
                .seatNumber(seatServiceClientResponse.getSeatNumber())
                .build();
    }
}
