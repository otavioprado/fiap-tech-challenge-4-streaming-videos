package com.challenge.streamingvideos.controller;
import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.service.VideosServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideosController {

    @Autowired
    private VideosServiceImpl videosService;

    @GetMapping
    public Flux<VideosDto> getVideos() {
        return videosService.findAll();
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
        videosService.deleteAll();
        return videosService.deleteAll();

    }

}
