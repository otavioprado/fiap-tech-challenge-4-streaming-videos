package com.challenge.streamingvideos.repository;

import com.challenge.streamingvideos.model.VideosModel;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface VideosRepository extends ReactiveMongoRepository<VideosModel, String> {
    //Buscar por titulo
    boolean existsByTitulo(String titulo);
    // Busca todos os vídeos
    Flux<VideosModel> findAll();
    // Busca todos os vídeos paginados
    Flux<VideosModel> findAllBy(Pageable pageable);
    //Buscar por categoria
    Flux<VideosModel> findByCategoria(String categoria);
    // Busca por lista de categoria
    Flux<VideosModel> findByCategoriaIn(List<String> categorias);
    // Conta a quantidade de favoritos
    Mono<Long> countByFavorito(boolean favorito);

}
