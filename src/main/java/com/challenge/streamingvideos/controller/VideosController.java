package com.challenge.streamingvideos.controller;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.usecase.VideosUsecaseImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideosController {

    private final VideosUsecaseImpl videosService;

    @GetMapping
    public Mono<Page<VideosDto>> getVideos(Pageable pageable) {
        return videosService.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public Mono<VideosDto> getVideosId(@PathVariable String id) {
        return videosService.findById(id);
    }

    @PostMapping
    public Mono<VideosDto> save(@Valid @RequestBody Mono<VideosDto> videosDtoMono) {
        return videosService.save(videosDtoMono);
    }

    @PutMapping(value = "/{id}")
    public Mono<VideosDto> updateVideo(@Valid @RequestBody Mono<VideosDto> videosDtoMono, @PathVariable String id) {
        return videosService.update(videosDtoMono, id);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Mono<Void> delete(@PathVariable String id) {
       return videosService.delete(id);
    }

    @GetMapping("/por-categoria")
    public Flux<VideosDto> getVideosPorCategoria(@RequestParam("categoria") String categoria) {
        return videosService.findByCategoria(categoria);
    }

    @GetMapping("/recomendados")
    public Flux<VideosDto> getVideosRecomendadosPorVideosFavoritados() {
        return videosService.recommendVideosBasedOnFavorites();
    }

}
