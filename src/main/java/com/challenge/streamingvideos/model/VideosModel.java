package com.challenge.streamingvideos.model;

import com.challenge.streamingvideos.enums.Categoria;
import com.challenge.streamingvideos.enums.TipoVideo;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document (collection = "videos")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideosModel {

    @Id
    private String idVideo;
    private String titulo;
    private String descricao;
    private Categoria categoria;
    private TipoVideo tipoVideo;
    private String urlVideo;

    private LocalDateTime publicacao;
}
