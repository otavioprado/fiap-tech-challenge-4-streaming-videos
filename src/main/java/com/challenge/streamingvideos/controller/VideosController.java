package com.challenge.streamingvideos.controller;

import com.challenge.streamingvideos.model.VideosModel;
import com.challenge.streamingvideos.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VideosController {

    @Autowired
    VideosService service;

    @GetMapping(value = "/videos")
    public Flux<VideosModel> getVideos() {
        return service.fildAll();
    }

    @GetMapping(value = "/videos/{id}")
    public Mono<VideosModel> getVideosId(@PathVariable String id) {
        return service.findById(id);
    }
    @PostMapping(value = "/videos")
    public Mono<VideosModel> save(@RequestBody VideosModel videos) {
        return service.save(videos);
    }


}
