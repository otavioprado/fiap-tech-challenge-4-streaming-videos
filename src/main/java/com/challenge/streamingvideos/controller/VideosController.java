package com.challenge.streamingvideos.controller;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.mapper.VideosMapper;
import com.challenge.streamingvideos.model.VideosModel;
import com.challenge.streamingvideos.service.VideosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")
@AllArgsConstructor
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
    public Mono<VideosDto> updateVideo(@RequestBody Mono<VideosDto> videosDtoMono,@PathVariable String id ){
        return videosService.update(videosDtoMono,id);
    }

    @DeleteMapping
    public Mono<Void> deleteById(@PathVariable String id){
        return videosService.deleteById(id);
    }





}
