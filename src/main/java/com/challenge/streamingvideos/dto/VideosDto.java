package com.challenge.streamingvideos.dto;

import com.challenge.streamingvideos.enums.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
public class VideosDto {

    private String id;
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}
