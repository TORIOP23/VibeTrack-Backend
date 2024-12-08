package com.vibetrack.aurora.repository;

import com.vibetrack.aurora.entity.Album;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AlbumRepository extends PagingAndSortingRepository<Album, String> {
    Optional<Album> findById(String albumId);
}
