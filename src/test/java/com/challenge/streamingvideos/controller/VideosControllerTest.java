package com.challenge.streamingvideos.controller;

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

@WebFluxTest(controllers = VideosController.class)
class VideosControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private VideosUsecaseImpl videosService;


    @BeforeEach
    public void setUp() {
        VideosDto video1 = new VideosDto();
        video1.setId("1");
        video1.setTitulo("piratas do caribe");
        Page<VideosDto> page = new PageImpl<>(Collections.singletonList(video1));

        when(videosService.findAll(ArgumentMatchers.any(Pageable.class))).thenReturn(Mono.just(page));
        when(videosService.findById("1")).thenReturn(Mono.just(video1));
        when(videosService.save(ArgumentMatchers.any())).thenReturn(Mono.just(video1));
        when(videosService.update(ArgumentMatchers.any(), ArgumentMatchers.eq("1"))).thenReturn(Mono.just(video1));
        when(videosService.delete(anyString())).thenReturn(Mono.empty()); // Correção aqui
        when(videosService.findByCategoria("acao")).thenReturn(Flux.just(video1));
        when(videosService.recommendVideosBasedOnFavorites()).thenReturn(Flux.just(video1));
    }

    @Test
    void testGetVideos() {
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

    @Test
    void testGetVideoById() {
        webTestClient.get()
                .uri("/videos/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.titulo").isEqualTo("piratas do caribe");
    }

    @Test
    void testCreateVideo() {
        VideosDto videoToCreate = new VideosDto();
        videoToCreate.setTitulo("novo video");

        webTestClient.post()
                .uri("/videos")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(videoToCreate), VideosDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.titulo").isEqualTo("piratas do caribe");
    }

    @Test
    void testUpdateVideo() {
        VideosDto videoToUpdate = new VideosDto();
        videoToUpdate.setTitulo("video atualizado");

        webTestClient.put()
                .uri("/videos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(videoToUpdate), VideosDto.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.titulo").isEqualTo("piratas do caribe");
    }

    @Test
    void testDeleteVideo() {
        webTestClient.delete()
                .uri("/videos/1")
                .exchange()
                .expectStatus().isOk();
        verify(videosService, times(1)).delete(anyString());
    }

    @Test
    void testGetVideosPorCategoria() {
        webTestClient.get()
                .uri("/videos/por-categoria?categoria=acao")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(VideosDto.class)
                .hasSize(1);
    }

    @Test
    void testGetVideosRecomendadosPorVideosFavoritados() {
        webTestClient.get()
                .uri("/videos/recomendados")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(VideosDto.class)
                .hasSize(1);
    }
}