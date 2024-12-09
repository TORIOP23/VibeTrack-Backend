package com.vibetrack.aurora.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistResponse {
    String playlistId;
    String name;
    String description;
    String ownerId;
    String imageUrl;
    int songCount;
}
