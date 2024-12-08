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
@Table(name = "album_pop")
public class AlbumPop {
    @Id
    @Column(name = "album_id", length = 22)
    String albumId;

    @Column(name = "year_end_score", length = 5)
    Integer yearEndScore;

    @Column(name = "is_pop", length = 5)
    String isPop;

    @Column(name = "year", length = 4)
    Integer year;
}
