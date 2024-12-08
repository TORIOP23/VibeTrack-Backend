package com.vibetrack.aurora.mapper;

import com.vibetrack.aurora.dto.response.AlbumDetailResponse;
import com.vibetrack.aurora.dto.response.AlbumResponse;
import com.vibetrack.aurora.dto.response.SongResponse;
import com.vibetrack.aurora.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AlbumMapper {

    AlbumResponse toAlbumResponse(Album album);

    AlbumDetailResponse toAlbumDetailResponse(Album album, List<SongResponse> songs);
}
