package com.vibetrack.aurora.service;

import com.vibetrack.aurora.dto.response.ArtistResponse;
import com.vibetrack.aurora.dto.response.PaginatedResponse;
import com.vibetrack.aurora.entity.Artist;
import com.vibetrack.aurora.mapper.ArtistMapper;
import com.vibetrack.aurora.repository.ArtistRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArtistService {
    ArtistRepository artistRepository;
    ArtistMapper artistMapper;

    public PaginatedResponse<ArtistResponse> getArtists(Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "popularity");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Artist> artists = artistRepository.findAll(paging);
        return new PaginatedResponse<>(artists.getTotalPages(), artists.getContent().stream().map(artistMapper::toArtistResponse).toList());
    }
}
