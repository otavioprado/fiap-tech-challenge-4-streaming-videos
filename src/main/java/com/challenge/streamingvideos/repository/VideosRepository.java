package com.challenge.streamingvideos.repository;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.model.VideosModel;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VideosRepository extends ReactiveMongoRepository<VideosModel, String> {
    boolean existsByTitulo(String titulo);
    Mono<VideosModel> findByTitulo(String titulo);
    Flux<VideosModel> findAll();

}
