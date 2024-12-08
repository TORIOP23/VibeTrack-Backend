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
@Table(name = "lyrics")
public class Lyric {

    @Id
    @Column(length = 22, nullable = false)
    String songId;

    @Column(columnDefinition = "MEDIUMTEXT")
    String lyrics;
}
