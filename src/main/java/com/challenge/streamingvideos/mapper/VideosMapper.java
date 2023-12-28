package com.challenge.streamingvideos.mapper;

import com.challenge.streamingvideos.dto.VideosDto;
import com.challenge.streamingvideos.model.VideosModel;
import org.mapstruct.Mapper;



@Mapper
public interface VideosMapper {

    VideosModel toEntity(VideosDto dto);
    VideosDto toDTO (VideosModel entity);

}
