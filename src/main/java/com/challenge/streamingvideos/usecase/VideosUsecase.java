package com.challenge.streamingvideos.usecase;

import com.challenge.streamingvideos.dto.StatisticsDto;
import com.challenge.streamingvideos.dto.VideosDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VideosUsecase {

    //bucar por id
    Mono<VideosDto> findById(String id);

    //salvar video
    Mono<VideosDto> save(Mono<VideosDto> videosDtoMono);

    //atualizar video
    Mono<VideosDto> update(Mono<VideosDto> videosDtoMono, String id);

    //excluir video
    Mono<Void> delete(String id);

    // buscar categoria
    Flux<VideosDto> findByCategoria(String categoria);

    Mono<StatisticsDto> getVideoStatistics();

    Flux<VideosDto> recommendVideosBasedOnFavorites();

    //buscar todos
    Mono<Page<VideosDto>> findAll(Pageable pageable);
}
