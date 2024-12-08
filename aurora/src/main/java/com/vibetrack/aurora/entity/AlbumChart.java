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
@Table(name = "album_chart")
public class AlbumChart {
    @Id
    @Column(name = "album_id", length = 22)
    String albumId;

    @Column(name = "rank_score")
    Integer rankScore;

    @Column(name = "peak_position")
    Integer peakPosition;

    @Column(name = "weeks_on_chart")
    Integer weeksOnChart;

    @Column(name = "week")
    Date week;
}
