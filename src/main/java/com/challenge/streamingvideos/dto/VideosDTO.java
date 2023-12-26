package com.challenge.streamingvideos.dto;

import com.challenge.streamingvideos.enums.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideosDTO {
    private String id;
    private String titulo;
    private String descricao;
    private Categoria categoria;
}
