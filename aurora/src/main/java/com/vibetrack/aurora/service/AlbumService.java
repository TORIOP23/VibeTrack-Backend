package com.vibetrack.aurora.service;

import com.vibetrack.aurora.dto.response.AlbumDetailResponse;
import com.vibetrack.aurora.dto.response.AlbumResponse;
import com.vibetrack.aurora.dto.response.PaginatedResponse;
import com.vibetrack.aurora.dto.response.SongResponse;
import com.vibetrack.aurora.entity.Album;
import com.vibetrack.aurora.entity.Song;
import com.vibetrack.aurora.exception.AppException;
import com.vibetrack.aurora.exception.ErrorCode;
import com.vibetrack.aurora.mapper.AlbumMapper;
import com.vibetrack.aurora.repository.AlbumRepository;
import com.vibetrack.aurora.repository.SongRepository;
import com.vibetrack.aurora.repository.TrackRepository;
import jakarta.transaction.Transactional;
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
public class AlbumService {
    AlbumRepository albumRepository;
    TrackRepository trackRepository;
    SongRepository songRepository;
    AlbumMapper albumMapper;

    public PaginatedResponse<AlbumResponse> getAlbums(Pageable pageable, boolean unpaged) {
        Sort sort = Sort.by(Sort.Direction.DESC, "popularity");
        Pageable paging = unpaged
                ? Pageable.unpaged(sort)
                : PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSortOr(sort));

        Page<Album> albums = albumRepository.findAll(paging);
        return new PaginatedResponse<>(albums.getTotalPages(), albums.getContent().stream().map(albumMapper::toAlbumResponse).toList());
    }

    @Transactional
    public AlbumDetailResponse getAlbumById(String albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow(
                () -> new AppException(ErrorCode.ALBUM_NOT_FOUND)
        );

        List<String> songIds = trackRepository.getSongIdsByAlbumId(albumId);
        List<SongResponse> songs = songRepository.findAllById(songIds).stream()
                .map(this::toSongResponse)
                .toList();

        return albumMapper.toAlbumDetailResponse(album, songs);
    }

    private SongResponse toSongResponse(Song song) {
        return SongResponse.builder()
                .songId(song.getSongId())
                .songName(song.getSongName())
                .billboard(song.getBillboard())
                .artists(song.getArtists())
                .popularity(song.getPopularity())
                .explicit(song.getExplicit())
                .songType(song.getSongType())
                .build();
    }
}
