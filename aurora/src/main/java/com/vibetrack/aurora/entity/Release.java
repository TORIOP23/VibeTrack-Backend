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
@Table(name = "releases")
public class Release {

    @Id
    @Column(name = "artist_id")
    String artistId;

    @Column(name = "album_id")
    String albumId;

    @Column(name = "release_date")
    String releaseDate;

    @Column(name = "release_date_precision")
    String releaseDatePrecision;
}