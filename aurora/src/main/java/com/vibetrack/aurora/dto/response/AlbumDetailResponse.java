package com.vibetrack.aurora.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlbumDetailResponse {
    String albumId;
    String name;
    String billboard;
    List<ShortArtistResponse> artists;
    Integer popularity;
    Integer totalTracks;
    String albumType;
    String imageUrl;
    List<SongResponse> songs;
}
