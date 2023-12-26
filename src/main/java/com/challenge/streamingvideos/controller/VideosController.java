package com.challenge.streamingvideos.controller;

import com.challenge.streamingvideos.dto.VideosDTO;
import com.challenge.streamingvideos.model.VideosModel;
import com.challenge.streamingvideos.repository.VideosRepository;
import com.challenge.streamingvideos.service.VideosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VideosController {

    @Autowired
    private VideosServiceImpl videosService;

    @GetMapping(value = "/videos")
    public Mono<Page<VideosModel>> getVideos(Pageable pageable) {
        return videosService.findAll(pageable);
    }

    @GetMapping(value = "/videos/{id}")
    public Mono<VideosModel> getVideosId(@PathVariable String id) {
        return videosService.findById(id);
    }

    @PostMapping(value = "/videos")
    public Mono<VideosModel> save(@RequestBody VideosModel videos) {
        return videosService.save(videos);
    }


}
