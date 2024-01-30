package com.challenge.streamingvideos.controller;

import com.challenge.streamingvideos.dto.StatisticsDto;
import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.usecase.VideosUsecaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static org.mockito.Mockito.*;

@WebFluxTest(controllers = StatisticsController.class)
class StatisticsControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private VideosUsecaseImpl videosService;

    @Test
    void testGetStatistics() {
        StatisticsDto dto = new StatisticsDto(3, 10);

        when(videosService.getVideoStatistics()).thenReturn(Mono.just(dto));

        WebTestClient.ResponseSpec response = webTestClient.get()
                .uri("/statistics")
                .exchange();

        response.expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("totalVideos").isEqualTo(3)
                .jsonPath("favoriteVideos").isEqualTo(10);
    }
}