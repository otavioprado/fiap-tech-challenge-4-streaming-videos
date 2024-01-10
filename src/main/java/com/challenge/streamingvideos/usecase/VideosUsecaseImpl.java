package com.challenge.streamingvideos.usecase;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.mapper.VideosMapper;
import com.challenge.streamingvideos.model.VideosModel;
import com.challenge.streamingvideos.repository.VideosRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class VideosUsecaseImpl implements VideosUsecase {

    private final VideosRepository videosRepository;
    private VideosMapper videosMapper;

    //buscar todos
    @Override
    public Mono<Page<VideosDto>> findAll(Pageable pageable) {
        return this.videosRepository.findAllBy(pageable)
                .collectList()
                .zipWith(this.videosRepository.count())
                .map(p -> new PageImpl<>(p.getT1(), pageable, p.getT2()))
                .map(page -> page.map(videosMapper::toDTO));
    }

    @Override
    public Flux<VideosDto> findByCategoria(String categoria) {
        return videosRepository.findByCategoria(categoria).map(videosMapper::toDTO);
    }

    //bucar por id
    @Override
    public Mono<VideosDto> findById(String id) {
        return videosRepository.findById(id).map(videosMapper::toDTO);
    }

    //salvar video
    @Override
    public Mono<VideosDto> save(Mono<VideosDto> videosDtoMono) {

        return videosDtoMono
                .map(videosMapper::toEntity)
                .flatMap(videosRepository::save)
                .map(videosMapper::toDTO);
    }

    //atualizar video
    @Override
    public Mono<VideosDto> update(Mono<VideosDto> videosDtoMono, String id) {
        return videosRepository.findById(id)
                .flatMap(video -> videosDtoMono.map(videosMapper::toEntity)
                        .doOnNext(videoAtualizado -> videoAtualizado.setId(video.getId()))
                        .flatMap(videosRepository::save)
                        .map(videosMapper::toDTO));
    }

    //excluir video
    @Override
    public Mono<Void> deleteAll() {
        return videosRepository.deleteAll();
    }
}
