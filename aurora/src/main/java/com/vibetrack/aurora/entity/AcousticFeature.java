package com.vibetrack.aurora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "acoustic_features")
public class AcousticFeature {

    @Id
    @Column(name = "song_id", length = 22)
    String songId;

    @Column(name = "duration_ms")
    Integer durationMs;

    @Column(name = "key")
    Integer key;

    @Column(name = "mode")
    Integer mode;

    @Column(name = "time_signature")
    Integer timeSignature;

    @Column(name = "acousticness", precision = 11, scale = 6)
    BigDecimal acousticness;

    @Column(name = "danceability", precision = 4, scale = 3)
    BigDecimal danceability;

    @Column(name = "energy", precision = 6, scale = 5)
    BigDecimal energy;

    @Column(name = "instrumentalness", precision = 12, scale = 7)
    BigDecimal instrumentalness;

    @Column(name = "liveness", precision = 5, scale = 4)
    BigDecimal liveness;

    @Column(name = "loudness", precision = 6, scale = 3)
    BigDecimal loudness;

    @Column(name = "speechiness", precision = 6, scale = 4)
    BigDecimal speechiness;

    @Column(name = "valence", precision = 5, scale = 4)
    BigDecimal valence;

    @Column(name = "tempo", precision = 6, scale = 3)
    BigDecimal tempo;
}

