package com.challenge.streamingvideos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class VideosModelTest {

    private VideosModel videosModel;

    @BeforeEach
    public void setUp() {
        videosModel = new VideosModel();
    }

    @Test
    public void testGettersAndSetters() {
        // Defina valores para os campos da classe
        String id = "1";
        String titulo = "Video de teste";
        String descricao = "Descrição do vídeo de teste";
        String urlVideo = "https://www.example.com/video";
        LocalDateTime dataPublicacao = LocalDateTime.now();
        String categoria = "Teste";
        Boolean favorito = true;

        videosModel.setId(id);
        videosModel.setTitulo(titulo);
        videosModel.setDescricao(descricao);
        videosModel.setUrlVideo(urlVideo);
        videosModel.setDataPublicacao(dataPublicacao);
        videosModel.setCategoria(categoria);
        videosModel.setFavorito(favorito);

        // Verifique se os getters retornam os valores definidos
        assertEquals(id, videosModel.getId());
        assertEquals(titulo, videosModel.getTitulo());
        assertEquals(descricao, videosModel.getDescricao());
        assertEquals(urlVideo, videosModel.getUrlVideo());
        assertEquals(dataPublicacao, videosModel.getDataPublicacao());
        assertEquals(categoria, videosModel.getCategoria());
        assertEquals(favorito, videosModel.getFavorito());
    }

    @Test
    public void testNoArgsConstructor() {
        assertNotNull(videosModel);
    }

    @Test
    public void testAllArgsConstructor() {
        // Crie um objeto usando o construtor com argumentos
        VideosModel videosModelWithArgs = new VideosModel("2", "Outro Vídeo", "Descrição", "https://www.example.com/outrovideo",
                LocalDateTime.now(), "Outra Categoria", false);

        assertNotNull(videosModelWithArgs);
        assertEquals("2", videosModelWithArgs.getId());
        assertEquals("Outro Vídeo", videosModelWithArgs.getTitulo());
        assertEquals("Descrição", videosModelWithArgs.getDescricao());
        assertEquals("https://www.example.com/outrovideo", videosModelWithArgs.getUrlVideo());
        assertNotNull(videosModelWithArgs.getDataPublicacao());
        assertEquals("Outra Categoria", videosModelWithArgs.getCategoria());
        assertFalse(videosModelWithArgs.getFavorito());
    }

    @Test
    public void testBuilder() {
        // Use o Builder para criar uma instância da classe
        VideosModel video = VideosModel.builder()
                .id("3")
                .titulo("Video com Builder")
                .descricao("Descrição do vídeo com Builder")
                .urlVideo("https://www.example.com/video_builder")
                .dataPublicacao(LocalDateTime.now())
                .categoria("Teste Builder")
                .favorito(true)
                .build();

        // Verifique se os valores definidos pelo Builder estão corretos
        assertEquals("3", video.getId());
        assertEquals("Video com Builder", video.getTitulo());
        assertEquals("Descrição do vídeo com Builder", video.getDescricao());
        assertEquals("https://www.example.com/video_builder", video.getUrlVideo());
        assertNotNull(video.getDataPublicacao());
        assertEquals("Teste Builder", video.getCategoria());
        assertTrue(video.getFavorito());
    }
}
