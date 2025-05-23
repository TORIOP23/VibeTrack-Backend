package com.vibetrack.aurora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @Column(name = "song_id", length = 22)
    String songId;

    @Column(name = "album_id", length = 22)
    String albumId;

    @Column(name = "track_number")
    Integer trackNumber;

    @Column(name = "release_date", length = 10)
    String releaseDate;

    @Column(name = "release_date_precision", length = 5)
    String releaseDatePrecision;
}
