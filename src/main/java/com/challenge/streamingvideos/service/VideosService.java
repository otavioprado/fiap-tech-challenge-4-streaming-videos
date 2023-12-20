package com.challenge.streamingvideos.service;

import com.challenge.streamingvideos.model.VideosModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VideosService {
    Flux<VideosModel> fildAll();
    Mono<VideosModel> findById(String id);
    Mono<VideosModel> save(VideosModel videosModel);

}
