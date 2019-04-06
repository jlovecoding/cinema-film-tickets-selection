package com.cinema.ticket.service.film;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("films")
public interface FilmServiceClient {

    @GetMapping("/films")
    List<FilmServiceClientResponse> findAll(@RequestParam(value = "title", required = false) final String title);

}
