package com.vibetrack.aurora.repository;

import com.vibetrack.aurora.entity.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends PagingAndSortingRepository<Album, String> {
    Optional<Album> findById(String albumId);

    @Query(value = "SELECT * FROM albums a WHERE a.artists LIKE %:artistId%", nativeQuery = true)
    List<Album> findByArtist(@Param("artistId") String artistId);

    @Query(value = "SELECT * FROM albums a WHERE a.name LIKE %:query% LIMIT 10", nativeQuery = true)
    List<Album> findByNameContaining(@Param("query") String query);
}
