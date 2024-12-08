package com.vibetrack.aurora.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistResponse {
    String artistId;
    String name;
    String followers;
    Integer popularity;
    String artistType;
    String mainGenre;
    String genres;
    String imageUrl;
}
