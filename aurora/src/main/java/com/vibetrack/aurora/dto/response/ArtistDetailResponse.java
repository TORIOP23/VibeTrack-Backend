package com.vibetrack.aurora.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistDetailResponse {
    String artistId;
    String name;
    String followers;
    Integer popularity;
    String artistType;
    String mainGenre;
    String genres;
    String imageUrl;
    List<SongResponse> songs;
    List<AlbumResponse> albums;
}
