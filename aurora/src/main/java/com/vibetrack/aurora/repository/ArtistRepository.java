package com.vibetrack.aurora.repository;

import com.vibetrack.aurora.entity.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, String> {
    Optional<Artist> findById(String artistId);


    @Query(value = "SELECT * FROM artists a WHERE a.name LIKE %:query% LIMIT 10", nativeQuery = true)
    List<Artist> findByNameContaining(@Param("query") String query);
}
