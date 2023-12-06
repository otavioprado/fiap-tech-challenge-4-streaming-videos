package com.challenge.streamingvideos.repository;

import com.challenge.streamingvideos.model.VideosModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VideosRepository extends ReactiveMongoRepository<VideosModel, String> {

}
