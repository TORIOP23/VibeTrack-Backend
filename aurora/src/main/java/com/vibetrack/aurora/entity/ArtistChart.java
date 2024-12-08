package com.vibetrack.aurora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "artist_chart")
public class ArtistChart {

    @Id
    @Column(name = "artist_id", length = 22)
    String artistId;

    @Column(name = "rank_score")
    Integer rankScore;

    @Column(name = "peak_position")
    Integer peakPosition;

    @Column(name = "weeks_on_chart")
    Integer weeksOnChart;

    @Column(name = "week")
    Date week;
}
