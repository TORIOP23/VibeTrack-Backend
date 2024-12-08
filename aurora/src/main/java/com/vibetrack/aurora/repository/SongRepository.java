package com.vibetrack.aurora.repository;

import com.vibetrack.aurora.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, String> {

    @Query(value = "SELECT * FROM songs s WHERE s.artists LIKE %:artistId%", nativeQuery = true)
    List<Song> findByArtist(@Param("artistId") String artistId);
}
