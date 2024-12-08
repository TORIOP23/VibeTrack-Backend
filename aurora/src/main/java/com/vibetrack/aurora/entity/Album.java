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
@Table(name = "albums")
public class Album {
    @Id
    @Column(name = "album_id", length = 22)
    String albumId;

    @Column(name = "name", length = 292)
    String name;

    @Column(name = "billboard", length = 75)
    String billboard;

    @Column(name = "artists", columnDefinition = "TEXT")
    String artists;

    @Column(name = "popularity")
    Integer popularity;

    @Column(name = "total_tracks")
    Integer totalTracks;

    @Column(name = "album_type", length = 11)
    String albumType;

    @Column(name = "image_url", length = 64)
    String imageUrl;
}
