package com.vibetrack.aurora.repository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TrackRepository {
    /**
     * JdbcClient for database operations
     */
    JdbcClient jdbcClient;

    /**
     * Retrieves all song IDs for a given album ID.
     *
     * @param albumId The ID of the album to retrieve songs for
     * @return List of song IDs in the specified album
     */
    public List<String> getSongIdsByAlbumId(String albumId) {
        String sql = "SELECT song_id FROM tracks WHERE album_id = ? ORDER BY track_number ASC";

        return jdbcClient.sql(sql)
                .param(albumId)
                .query((rs, rowNum) -> rs.getString("song_id"))
                .list();
    }
}
