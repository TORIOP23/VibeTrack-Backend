package com.vibetrack.aurora.mapper;

import com.vibetrack.aurora.dto.response.AlbumResponse;
import com.vibetrack.aurora.dto.response.ArtistDetailResponse;
import com.vibetrack.aurora.dto.response.ArtistResponse;
import com.vibetrack.aurora.dto.response.SongResponse;
import com.vibetrack.aurora.entity.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArtistMapper {

    ArtistResponse toArtistResponse(Artist artist);

    ArtistDetailResponse toArtistDetailResponse(Artist artist, List<SongResponse> songs, List<AlbumResponse> albums);
}
