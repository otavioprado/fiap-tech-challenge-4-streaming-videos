package com.challenge.streamingvideos.repository;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.mapper.VideosMapper;
import com.challenge.streamingvideos.model.VideosModel;
import com.challenge.streamingvideos.usecase.VideosUsecase;
import com.challenge.streamingvideos.usecase.VideosUsecaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VideosRepositoryTest {
  /*  private VideosUsecase videosUsecase;
    private VideosRepository videosRepository;
    private VideosMapper videosMapper;

    @BeforeEach
    void setup () {
        videosMapper = mock (VideosMapper.class);
        videosUsecase = new VideosUsecaseImpl(videosRepository, videosMapper);
        videosRepository = mock(VideosRepository.class);
        }

    @Test
    void deveBuscarTodosOsVideosRepository(){

        fail("Teste não implementado!");
    }
    @Test
    /*void deveBuscarTodosOsVideosPaginadosRepository(){
            // Configuração do mock
            String categoria = "Categoria 1";
            VideosModel video1 = new VideosModel();
            video1.setId("1");
            video1.setTitulo("Video 1");
            video1.setCategoria(categoria);

            VideosModel video2 = new VideosModel();
            video2.setId("2");
            video2.setTitulo("Video 2");
            video2.setCategoria(categoria);

            Mockito.when(videosRepository.findByCategoria(categoria)).thenReturn(Flux.just(video1, video2));
            Mockito.when(videosMapper.toDTO(video1)).thenReturn(new VideosDto());
            Mockito.when(videosMapper.toDTO(video2)).thenReturn(new VideosDto());

            // Executar o método e fazer asserções
            videosUsecase.findByCategoria(categoria).collectList().subscribe(videos -> {
                assert videos.size() == 2;
                assert videos.get(0).getId().equals("1");
                assert videos.get(1).getId().equals("2");
            });

            // Verificar se os métodos do mock foram chamados
            verify(videosRepository, times(1)).findByCategoria(categoria);
            verify(videosMapper, times(1)).toDTO(video1);
            verify(videosMapper, times(1)).toDTO(video2);
    }
    @Test
    void deveBuscarPorCategoriaRepository(){
        fail("Teste não implementado!");
    }
    @Test
    void deveBuscarPorListaDeCategoriaRepository()
    {
        fail("Teste não implementado!");
    }
    @Test
    void deveContarAQuantidadeDeFavoritosRepository(){

        fail("Teste não implementado!");
    }
*/
}