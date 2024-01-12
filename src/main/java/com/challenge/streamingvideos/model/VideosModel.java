package com.challenge.streamingvideos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "videos")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideosModel {

    @Id
    private String id;
    private String titulo;
    private String descricao;
    private String urlVideo;
    private LocalDateTime dataPublicacao;
    private String categoria;
    private Boolean favorito;
}
