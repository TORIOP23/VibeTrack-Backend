package com.vibetrack.aurora.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vibetrack.aurora.dto.response.ShortArtistResponse;
import com.vibetrack.aurora.dto.response.SongResponse;
import com.vibetrack.aurora.entity.Song;
import com.vibetrack.aurora.exception.AppException;
import com.vibetrack.aurora.exception.ErrorCode;
import com.vibetrack.aurora.util.ApplicationInit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class SongMapper {

    public SongResponse toSongResponse(Song song) {
        String url = "http://" + ApplicationInit.ipAddress + ":9002/aurora/audio/" + song.getSongId() + ".mp3";
        return SongResponse.builder()
                .songId(song.getSongId())
                .songName(song.getSongName())
                .billboard(song.getBillboard())
                .artists(parseJson(song.getArtists()))
                .popularity(song.getPopularity())
                .explicit(song.getExplicit())
                .songType(song.getSongType())
                .url(url)
                .build();
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