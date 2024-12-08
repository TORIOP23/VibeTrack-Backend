package com.vibetrack.aurora.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SongResponse {
    String songId;
    String songName;
    String billboard;
    String artists;
    Integer popularity;
    String explicit;
    String songType;
    String url;
}
