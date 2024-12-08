package com.vibetrack.aurora.repository;

import com.vibetrack.aurora.entity.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, String> {
}
