package com.challenge.streamingvideos.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideosDto {

    private String id;
    private String titulo;
    private String descricao;
    private String urlVideo;
    private String dataPublicacao;
    private String categoria;

}
