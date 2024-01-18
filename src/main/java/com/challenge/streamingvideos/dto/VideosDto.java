package com.challenge.streamingvideos.dto;

import com.challenge.streamingvideos.enums.CategoriaEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideosDto {

    private String id;

    @NotBlank
    @Size(min = 2, max = 100, message = "[titulo] : Deve conter de 2 até 100 caracteres.")
    private String titulo;

    @NotNull
    @Size(min = 1, max = 1000)
    private String descricao;

    @NotNull
    @Pattern(regexp = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
            message = "[urlVideo] Contém caractere inválido")
    private String urlVideo;

    @NotNull
    @Past
    private LocalDateTime dataPublicacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    private Boolean favorito;
}
