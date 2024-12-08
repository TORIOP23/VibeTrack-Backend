package com.vibetrack.aurora.mapper;

import com.vibetrack.aurora.dto.response.ArtistResponse;
import com.vibetrack.aurora.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArtistMapper {

    ArtistResponse toArtistResponse(Artist artist);
}
