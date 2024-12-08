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
@Table(name = "song_pop")
public class SongPop {
    @Id
    @Column(name = "song_id", length = 22)
    String songId;

    @Column(name = "year_end_score")
    Integer yearEndScore;

    @Column(name = "year")
    Integer year;
}
