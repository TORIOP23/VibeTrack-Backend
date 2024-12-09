package com.vibetrack.aurora.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistDetailResponse {
    String playlistId;
    String name;
    String description;
    String ownerId;
    String imageUrl;
    List<SongResponse> songs;
}
