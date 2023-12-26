package com.challenge.streamingvideos.service;

import com.challenge.streamingvideos.mapper.VideosMapper;
import com.challenge.streamingvideos.model.VideosModel;
import com.challenge.streamingvideos.repository.VideosRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Builder
@AllArgsConstructor
@Slf4j
public class VideosServiceImpl implements VideosService {

    @Autowired
    private VideosRepository videosRepository;
    private VideosService videosService;
    private final VideosMapper videosMapper;


    //buscar todos
    @Override
    public Mono<Page<VideosModel>> findAll(Pageable pageable) {
        return this.videosRepository.findAllBy(pageable)
                .collectList()
                .zipWith(this.videosRepository.count())
                .map(p -> new PageImpl<>(p.getT1(), pageable, p.getT2()));
    }

    //bucar por id
    @Override
    public Mono<VideosModel> findById(String id) {
        return videosRepository.findById(id);
    }

    //salvar video
    @Override
    public Mono<VideosModel> save(VideosModel videosModel) {
        return videosRepository.save(videosModel);
    }

    //atualizar video
    @Override
    public Mono<VideosModel> update(VideosModel videosModel) {
        return null;
    }

    //excluir video
    @Override
    public Mono<VideosModel> deleteById(VideosModel videosModel) {
        return null;
    }
}
