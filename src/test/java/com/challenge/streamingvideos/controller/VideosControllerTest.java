package com.challenge.streamingvideos.controller;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.usecase.VideosUsecaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = VideosController.class)
public class VideosControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private VideosUsecaseImpl videosService;

    private VideosController videosController;

    @Test
    public void testGetVideos() {
        VideosDto video1 = new VideosDto();
        video1.setId("1");
        video1.setTitulo("piratas do caribe");
        Page<VideosDto> page = new PageImpl<>(Collections.singletonList(video1));

        when(videosService.findAll(any(Pageable.class))).thenReturn(Mono.just(page));

        WebTestClient.ResponseSpec response = webTestClient.get()
                .uri("/videos")
                .exchange();

        response.expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.content[0].id").isEqualTo("1")
                .jsonPath("$.content[0].titulo").isEqualTo("piratas do caribe");
    }
}