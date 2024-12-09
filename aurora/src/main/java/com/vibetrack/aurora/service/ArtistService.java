package com.vibetrack.aurora.service;

import com.vibetrack.aurora.dto.response.*;
import com.vibetrack.aurora.entity.Artist;
import com.vibetrack.aurora.exception.AppException;
import com.vibetrack.aurora.exception.ErrorCode;
import com.vibetrack.aurora.mapper.AlbumMapper;
import com.vibetrack.aurora.mapper.ArtistMapper;
import com.vibetrack.aurora.mapper.SongMapper;
import com.vibetrack.aurora.repository.AlbumRepository;
import com.vibetrack.aurora.repository.ArtistRepository;
import com.vibetrack.aurora.repository.SongRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArtistService {
    ArtistRepository artistRepository;
    ArtistMapper artistMapper;
    SongMapper songMapper;
    AlbumMapper albumMapper;
    SongRepository songRepository;
    AlbumRepository albumRepository;

    public PaginatedResponse<ArtistResponse> getArtists(Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "popularity");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Artist> artists = artistRepository.findAll(paging);
        return new PaginatedResponse<>(artists.getTotalPages(), artists.getContent().stream().map(artistMapper::toArtistResponse).toList());
    }

    public ArtistDetailResponse getArtistById(String artistId) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(
                () -> new AppException(ErrorCode.ARTIST_NOT_FOUND)
        );

        List<SongResponse> songs = songRepository.findByArtist(artistId).stream().map(songMapper::toSongResponse).toList();
        List<AlbumResponse> albums = albumRepository.findByArtist(artistId).stream().map(albumMapper::toAlbumResponse).toList();

        return artistMapper.toArtistDetailResponse(artist, songs, albums);
    }

    public List<ArtistResponse> getArtistsByName(String name) {
        return artistRepository.findByNameContaining(name).stream()
                .map(artistMapper::toArtistResponse)
                .toList();
    }
}
