package com.challenge.streamingvideos.controller;

import com.challenge.streamingvideos.dto.StatisticsDto;
import com.challenge.streamingvideos.usecase.VideosUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final VideosUsecase videosUsecase;

    @Autowired
    public StatisticsController(VideosUsecase videosUsecase) {
        this.videosUsecase = videosUsecase;
    }

    @GetMapping
    public Mono<StatisticsDto> getStatistics() {
        return videosUsecase.getVideoStatistics();
    }
}