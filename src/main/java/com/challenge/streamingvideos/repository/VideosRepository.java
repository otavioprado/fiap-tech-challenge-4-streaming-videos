package com.challenge.streamingvideos.repository;

import com.challenge.streamingvideos.model.VideosModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface VideosRepository extends ReactiveMongoRepository<VideosModel, String> {
    boolean existsByIdVideo(String id);

}
