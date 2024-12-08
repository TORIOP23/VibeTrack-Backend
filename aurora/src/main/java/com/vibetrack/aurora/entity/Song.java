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
@Table(name = "songs")
public class Song {
    @Id
    @Column(name = "song_id", length = 22)
    String songId;

    @Column(name = "song_name", length = 194)
    String songName;

    @Column(name = "billboard", length = 112)
    String billboard;

    @Column(name = "artists", columnDefinition = "TEXT")
    String artists;

    @Column(name = "popularity")
    Integer popularity;

    @Column(name = "explicit", length = 5)
    String explicit;

    @Column(name = "song_type", length = 13)
    String songType;
}
