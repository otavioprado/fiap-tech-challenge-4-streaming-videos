package com.challenge.streamingvideos.mapper;

import com.challenge.streamingvideos.dto.VideosDTO;
import com.challenge.streamingvideos.model.VideosModel;
import org.mapstruct.Mapper;

@Mapper
public interface VideosMapper {

    VideosModel toEntity(VideosDTO dto);
    VideosDTO toDTO (VideosModel entity);

}
