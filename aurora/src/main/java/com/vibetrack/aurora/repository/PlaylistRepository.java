package com.vibetrack.aurora.repository;

import com.vibetrack.aurora.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
    // count playlists by ownerId
    int countByOwnerId(String ownerId);

    List<Playlist> findByOwnerId(String userId);
}
