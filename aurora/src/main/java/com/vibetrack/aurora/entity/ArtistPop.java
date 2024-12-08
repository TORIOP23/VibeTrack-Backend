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
@Table(name = "artist_pop")
public class ArtistPop {

    @Id
    @Column(name = "artist_id", length = 22)
    String artistId;

    @Column(name = "year_end_score")
    Integer yearEndScore;

    @Column(name = "year")
    Integer year;
}
