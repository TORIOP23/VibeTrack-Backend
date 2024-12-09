package com.vibetrack.aurora.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistUpdateRequest {
    String name;
    String description;
    String imageUrl;
}
