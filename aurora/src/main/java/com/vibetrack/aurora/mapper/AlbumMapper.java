package com.vibetrack.aurora.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vibetrack.aurora.dto.response.AlbumDetailResponse;
import com.vibetrack.aurora.dto.response.AlbumResponse;
import com.vibetrack.aurora.dto.response.ShortArtistResponse;
import com.vibetrack.aurora.dto.response.SongResponse;
import com.vibetrack.aurora.entity.Album;
import com.vibetrack.aurora.exception.AppException;
import com.vibetrack.aurora.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class AlbumMapper {

    public AlbumResponse toAlbumResponse(Album album) {
        if (album == null) {
            return null;
        }

        AlbumResponse.AlbumResponseBuilder albumResponse = AlbumResponse.builder();

        albumResponse.albumId(album.getAlbumId());
        albumResponse.name(album.getName());
        albumResponse.billboard(album.getBillboard());

        albumResponse.artists(parseJson(album.getArtists()));

        albumResponse.popularity(album.getPopularity());
        albumResponse.totalTracks(album.getTotalTracks());
        albumResponse.albumType(album.getAlbumType());
        albumResponse.imageUrl(album.getImageUrl());

        return albumResponse.build();
    }

    public AlbumDetailResponse toAlbumDetailResponse(Album album, List<SongResponse> songs) {
        if (album == null && songs == null) {
            return null;
        }

        AlbumDetailResponse.AlbumDetailResponseBuilder albumDetailResponse = AlbumDetailResponse.builder();

        if (album != null) {
            albumDetailResponse.albumId(album.getAlbumId());
            albumDetailResponse.name(album.getName());
            albumDetailResponse.billboard(album.getBillboard());
            albumDetailResponse.artists(parseJson(album.getArtists()));
            albumDetailResponse.popularity(album.getPopularity());
            albumDetailResponse.totalTracks(album.getTotalTracks());
            albumDetailResponse.albumType(album.getAlbumType());
            albumDetailResponse.imageUrl(album.getImageUrl());
        }
        if (songs != null) {
            albumDetailResponse.songs(songs);
        }
        return albumDetailResponse.build();
    }

    private List<ShortArtistResponse> parseJson(String json) {
        try {
            String validJson = json.replace("'", "\"");
            // parse json string to map
            ObjectMapper objectMapper = new ObjectMapper();
            // artist is json string, parse it
            Map<String, String> map = objectMapper.readValue(validJson, Map.class);

            return map.entrySet().stream()
                    .map(entry -> ShortArtistResponse.builder()
                            .artistId(entry.getKey())
                            .name(entry.getValue())
                            .build())
                    .toList();
        } catch (JsonProcessingException e) {
            log.error("Error parsing json: {}", json);
            throw new AppException(ErrorCode.ERROR_PARSING_JSON);
        }
    }
}
