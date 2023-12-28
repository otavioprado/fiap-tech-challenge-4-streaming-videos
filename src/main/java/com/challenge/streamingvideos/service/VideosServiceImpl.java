package com.challenge.streamingvideos.service;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.mapper.VideosMapper;
import com.challenge.streamingvideos.repository.VideosRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class VideosServiceImpl implements VideosService {

    @Autowired
    private final VideosRepository videosRepository;
    private VideosMapper videosMapper;


    //buscar todos
    @Override
    public Flux<VideosDto> findAll() {
       return videosRepository.findAll().map(videosMapper::toDTO);
    }

    //bucar por id
    @Override
    public Mono<VideosDto> findById(String id) {
        return videosRepository.findById(id).map(videosMapper::toDTO);
    }

    //salvar video
    @Override
    public Mono<VideosDto> save(Mono<VideosDto> videosDtoMono) {
      return  videosDtoMono.map(videosMapper::toEntity)
                .flatMap(videosRepository::insert)
                .map(videosMapper::toDTO);
    }

    //atualizar video
    @Override
    public Mono<VideosDto> update(Mono<VideosDto> videosDtoMono, String id) {
        return videosRepository.findById(id)
                .flatMap(v->videosDtoMono.map(videosMapper::toEntity)
                .doOnNext(e->e.setIdVideo(id)))
                .flatMap(videosRepository::save)
                .map(videosMapper::toDTO);
    }

    //excluir video
    @Override
    public Mono<Void> deleteById(String id) {
        return videosRepository.deleteById(id);
    }
}
