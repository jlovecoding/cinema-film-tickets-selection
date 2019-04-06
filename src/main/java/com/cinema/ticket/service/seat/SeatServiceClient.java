package com.cinema.ticket.service.seat;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@FeignClient("seats")
public interface SeatServiceClient {

    @GetMapping("/seats")
    List<SeatServiceClientResponse> findByScreenAndStartAndAvailable(
            @RequestParam final Integer screen,
            @RequestParam @DateTimeFormat(iso = DATE_TIME) final LocalDateTime start,
            @RequestParam final Boolean available);
}
