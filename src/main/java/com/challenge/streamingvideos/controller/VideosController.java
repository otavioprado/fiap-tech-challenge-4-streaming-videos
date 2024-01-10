package com.challenge.streamingvideos.controller;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.service.VideosServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideosController {

    @Autowired
    private VideosServiceImpl videosService;

    @GetMapping
    public Mono<Page<VideosDto>> getVideos(Pageable pageable) {
        return videosService.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public Mono<VideosDto> getVideosId(@PathVariable String id) {
        return videosService.findById(id);
    }

    @PostMapping
    public Mono<VideosDto> save(@RequestBody Mono<VideosDto> videosDtoMono) {
        return videosService.save(videosDtoMono);
    }

    @PutMapping(value = "/{id}")
    public Mono<VideosDto> updateVideo(@RequestBody Mono<VideosDto> videosDtoMono, @PathVariable String id) {
        return videosService.update(videosDtoMono, id);
    }

    @DeleteMapping()
    public Mono<Void> deletarTodos() {
        return videosService.deleteAll();
    }

}
