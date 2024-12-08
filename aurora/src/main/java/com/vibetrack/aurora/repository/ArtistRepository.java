package com.vibetrack.aurora.repository;

import com.vibetrack.aurora.entity.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, String> {
    Optional<Artist> findById(String artistId);
}
