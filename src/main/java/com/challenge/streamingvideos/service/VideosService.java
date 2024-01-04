package com.challenge.streamingvideos.service;

import com.challenge.streamingvideos.dto.VideosDto;

import com.challenge.streamingvideos.model.VideosModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VideosService {
    //buscar todos
    Flux<VideosDto> findAll();

    //bucar por id
    Mono<VideosDto> findById(String id);

    //salvar video
    Mono<VideosDto> save(Mono<VideosDto> videosDtoMono);

    //atualizar video
    Mono<VideosDto> update(Mono<VideosDto> videosDtoMono, String id);

    //excluir video
    Mono<Void> deleteAll();

}
