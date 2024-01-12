package com.challenge.streamingvideos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticsDto {
    private long totalVideos;
    private long favoriteVideos;
}
