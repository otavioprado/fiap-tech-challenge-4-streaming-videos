package com.challenge.streamingvideos.usecase;

import com.challenge.streamingvideos.dto.VideosDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface VideosUsecase {
    //buscar todos
    Mono<Page<VideosDto>> findAll(Pageable pageable);

    //bucar por id
    Mono<VideosDto> findById(String id);

    //salvar video
    Mono<VideosDto> save(Mono<VideosDto> videosDtoMono);

    //atualizar video
    Mono<VideosDto> update(Mono<VideosDto> videosDtoMono, String id);

    //excluir video
    Mono<Void> deleteAll();

}
