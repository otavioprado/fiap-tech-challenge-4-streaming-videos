package com.challenge.streamingvideos.service;

import com.challenge.streamingvideos.model.VideosModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VideosService {
    //buscar todos
    Mono<Page<VideosModel>> findAll(Pageable pageable);

    //bucar por id
    Mono<VideosModel> findById(String id);

    //salvar video
    Mono<VideosModel> save(VideosModel videosModel);

    //atualizar video
    Mono<VideosModel> update(VideosModel videosModel);
    //excluir video
    Mono<VideosModel> deleteById(VideosModel videosModel);

}
