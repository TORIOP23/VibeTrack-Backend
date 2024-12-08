package com.vibetrack.aurora.repository;

import com.vibetrack.aurora.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, String> {
}
