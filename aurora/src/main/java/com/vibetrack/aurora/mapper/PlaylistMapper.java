package com.vibetrack.aurora.mapper;

import com.vibetrack.aurora.dto.request.PlaylistUpdateRequest;
import com.vibetrack.aurora.dto.response.PlaylistDetailResponse;
import com.vibetrack.aurora.dto.response.PlaylistResponse;
import com.vibetrack.aurora.entity.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaylistMapper {
    PlaylistResponse toPlaylistResponse(Playlist playlist);

    @Mapping(target = "songs", ignore = true)
    PlaylistDetailResponse toPlaylistDetailResponse(Playlist playlist);


    @Mapping(target = "playlistId", ignore = true)
    @Mapping(target = "ownerId", ignore = true)
    @Mapping(target = "songs", ignore = true)
    @Mapping(target = "songCount", ignore = true)
    void updatePlaylist(@MappingTarget Playlist user, PlaylistUpdateRequest request);
}
