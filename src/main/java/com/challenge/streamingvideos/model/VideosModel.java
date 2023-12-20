package com.challenge.streamingvideos.model;

import com.challenge.streamingvideos.enums.Categoria;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document (collection = "videos")
@Setter
@Getter
@Builder
public class VideosModel {

    @Id
    private String id;
    private String titulo;
    private String descricao;
    private Categoria categoria;
    private String url;
    private Date publicacao;
}
