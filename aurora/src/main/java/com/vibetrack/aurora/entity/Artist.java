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
@Table(name = "artists")
public class Artist {
    @Id
    @Column(name = "artist_id", length = 22)
    String artistId;

    @Column(name = "name", length = 91)
    String name;

    @Column(name = "followers", length = 8)
    String followers;

    @Column(name = "popularity", length = 3)
    Integer popularity;

    @Column(name = "artist_type", length = 6)
    String artistType;

    @Column(name = "main_genre", length = 33)
    String mainGenre;

    @Column(name = "genres", length = 401)
    String genres;

    @Column(name = "image_url", length = 64)
    String imageUrl;
}
