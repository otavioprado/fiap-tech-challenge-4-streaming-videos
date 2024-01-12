package com.challenge.streamingvideos.service;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.mapper.VideosMapper;
import com.challenge.streamingvideos.model.VideosModel;
import com.challenge.streamingvideos.repository.VideosRepository;
import com.challenge.streamingvideos.usecase.VideosUsecaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class VideosUsecaseImplTest {

    private VideosUsecaseImpl videosUsecase;
    private VideosRepository videosRepository;
    private VideosMapper videosMapper;

    @BeforeEach
    public void setUp() {
        videosRepository = mock(VideosRepository.class);
        videosMapper = mock(VideosMapper.class);
        videosUsecase = new VideosUsecaseImpl(videosRepository, videosMapper);
    }

    @Test
    public void testFindAll() {
        // Configuração do mock
        Pageable pageable = Pageable.ofSize(10).withPage(1);
        VideosModel video1 = new VideosModel();
        video1.setId("1");
        video1.setTitulo("Video 1");
        List<VideosModel> videosList = new ArrayList<>();
        videosList.add(video1);
        Page<VideosModel> page = new PageImpl<>(videosList);

        when(videosRepository.findAllBy(pageable)).thenReturn(Flux.just(video1));
        when(videosRepository.count()).thenReturn(Mono.just(1L));
        when(videosMapper.toDTO(video1)).thenReturn(new VideosDto());

        // Executar o método e fazer asserções
        videosUsecase.findAll(pageable).subscribe(videosPage -> {
            assert videosPage.getTotalElements() == 1;
            assert videosPage.getContent().get(0).getId().equals("1");
            assert videosPage.getContent().get(0).getTitulo().equals("Video 1");
        });

        // Verificar se os métodos do mock foram chamados
        verify(videosRepository, times(1)).findAllBy(pageable);
        verify(videosRepository, times(1)).count();
        verify(videosMapper, times(1)).toDTO(video1);
    }

    @Test
    public void testFindByCategoria() {
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

        when(videosRepository.findByCategoria(categoria)).thenReturn(Flux.just(video1, video2));
        when(videosMapper.toDTO(video1)).thenReturn(new VideosDto());
        when(videosMapper.toDTO(video2)).thenReturn(new VideosDto());

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
    public void testFindById() {
        // Configuração do mock
        String videoId = "1";
        VideosModel video1 = new VideosModel();
        video1.setId(videoId);
        video1.setTitulo("Video 1");

        when(videosRepository.findById(videoId)).thenReturn(Mono.just(video1));
        when(videosMapper.toDTO(video1)).thenReturn(new VideosDto());

        // Executar o método e fazer asserções
        videosUsecase.findById(videoId).subscribe(videoDto -> {
            assert videoDto.getId().equals(videoId);
            assert videoDto.getTitulo().equals("Video 1");
        });

        // Verificar se os métodos do mock foram chamados
        verify(videosRepository, times(1)).findById(videoId);
        verify(videosMapper, times(1)).toDTO(video1);
    }

    @Test
    public void testSave() {
        // Configuração do mock
        VideosDto videoDtoToSave = new VideosDto();
        VideosModel videoToSave = new VideosModel();
        videoToSave.setId("1");
        videoToSave.setTitulo("Video 1");

        when(videosMapper.toEntity(videoDtoToSave)).thenReturn(videoToSave);
        when(videosRepository.save(videoToSave)).thenReturn(Mono.just(videoToSave));
        when(videosMapper.toDTO(videoToSave)).thenReturn(videoDtoToSave);

        // Executar o método e fazer asserções
        videosUsecase.save(Mono.just(videoDtoToSave)).subscribe(savedVideoDto -> {
            assert savedVideoDto.getId().equals("1");
            assert savedVideoDto.getTitulo().equals("Video 1");
        });

        // Verificar se os métodos do mock foram chamados
        verify(videosMapper, times(1)).toEntity(videoDtoToSave);
        verify(videosRepository, times(1)).save(videoToSave);
        verify(videosMapper, times(1)).toDTO(videoToSave);
    }

    @Test
    public void testUpdate() {
        // Configuração do mock
        String videoId = "1";
        VideosDto videoDtoToUpdate = new VideosDto();
        VideosModel videoToUpdate = new VideosModel();
        videoToUpdate.setId(videoId);
        videoToUpdate.setTitulo("Video Atualizado");

        when(videosRepository.findById(videoId)).thenReturn(Mono.just(videoToUpdate));
        when(videosMapper.toEntity(videoDtoToUpdate)).thenReturn(videoToUpdate);
        when(videosRepository.save(videoToUpdate)).thenReturn(Mono.just(videoToUpdate));
        when(videosMapper.toDTO(videoToUpdate)).thenReturn(videoDtoToUpdate);

        // Executar o método e fazer asserções
        videosUsecase.update(Mono.just(videoDtoToUpdate), videoId).subscribe(updatedVideoDto -> {
            assert updatedVideoDto.getId().equals("1");
            assert updatedVideoDto.getTitulo().equals("Video Atualizado");
        });

        // Verificar se os métodos do mock foram chamados
        verify(videosRepository, times(1)).findById(videoId);
        verify(videosMapper, times(1)).toEntity(videoDtoToUpdate);
        verify(videosRepository, times(1)).save(videoToUpdate);
        verify(videosMapper, times(1)).toDTO(videoToUpdate);
    }

    @Test
    public void testDeleteAll() {
        // Configuração do mock
        when(videosRepository.deleteAll()).thenReturn(Mono.empty());

        // Executar o método e fazer asserções
        videosUsecase.deleteAll().subscribe();

        // Verificar se o método do mock foi chamado
        verify(videosRepository, times(1)).deleteAll();
    }
}
