package com.challenge.streamingvideos.service;

import com.challenge.streamingvideos.model.VideosModel;
import com.challenge.streamingvideos.repository.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VideosServiceImpl implements VideosService {

    @Autowired
    VideosRepository vr;

    @Override
    public Flux<VideosModel> fildAll() {
        return vr.findAll();
    }

    @Override
    public Mono<VideosModel> findById(String id) {
        return vr.findById(id);
    }

    @Override
    public Mono<VideosModel> save(VideosModel videosModel) {
        return vr.save(videosModel);
    }
}
