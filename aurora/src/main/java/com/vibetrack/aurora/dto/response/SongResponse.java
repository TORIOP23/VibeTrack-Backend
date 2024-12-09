package com.vibetrack.aurora.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SongResponse {
    String songId;
    String songName;
    String billboard;
    List<ShortArtistResponse> artists;
    Integer popularity;
    String explicit;
    String songType;
    String url;
}
