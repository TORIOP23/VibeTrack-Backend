package com.vibetrack.aurora.mapper;

import com.vibetrack.aurora.dto.response.SongResponse;
import com.vibetrack.aurora.entity.Song;
import com.vibetrack.aurora.util.ApplicationInit;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {

    public SongResponse toSongResponse(Song song) {
        String url = "http://" + ApplicationInit.ipAddress + ":9002/aurora/audio/" + song.getSongId() + ".mp3";
        return SongResponse.builder()
                .songId(song.getSongId())
                .songName(song.getSongName())
                .billboard(song.getBillboard())
                .artists(song.getArtists())
                .popularity(song.getPopularity())
                .explicit(song.getExplicit())
                .songType(song.getSongType())
                .url(url)
                .build();
    }
}