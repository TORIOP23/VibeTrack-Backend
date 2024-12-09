package com.vibetrack.aurora.service;

import com.vibetrack.aurora.dto.request.PlaylistUpdateRequest;
import com.vibetrack.aurora.dto.response.PlaylistDetailResponse;
import com.vibetrack.aurora.dto.response.PlaylistResponse;
import com.vibetrack.aurora.entity.Playlist;
import com.vibetrack.aurora.exception.AppException;
import com.vibetrack.aurora.exception.ErrorCode;
import com.vibetrack.aurora.mapper.PlaylistMapper;
import com.vibetrack.aurora.mapper.SongMapper;
import com.vibetrack.aurora.repository.PlaylistRepository;
import com.vibetrack.aurora.repository.SongRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaylistService {
    PlaylistRepository playlistRepository;
    PlaylistMapper playlistMapper;
    SongMapper songMapper;
    SongRepository songRepository;


    public PlaylistResponse createPlaylist(String userId) {
        var count = playlistRepository.countByOwnerId(userId);

        var newPlaylist = Playlist.builder()
                .name("My Playlist #" + (count + 1))
                .description("")
                .ownerId(userId)
                .build();

        var savedPlaylist = playlistRepository.save(newPlaylist);
        return playlistMapper.toPlaylistResponse(savedPlaylist);
    }

    public List<PlaylistResponse> getPlaylists(String userId) {
        var playlists = playlistRepository.findByOwnerId(userId);
        return playlists.stream()
                .map(playlistMapper::toPlaylistResponse)
                .toList();
    }

    public PlaylistDetailResponse getPlaylistDetail(String userId, String playlistId) {
        var playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new AppException(ErrorCode.PLAYLIST_NOT_FOUND));

        if (!playlist.getOwnerId().equals(userId)) {
            throw new AppException(ErrorCode.PLAYLIST_NOT_FOUND);
        }

        var songs = playlist.getSongs().stream()
                .map(songMapper::toSongResponse)
                .toList();

        var response = playlistMapper.toPlaylistDetailResponse(playlist);
        response.setSongs(songs);
        return response;
    }

    public void deletePlaylist(String userId, String playlistId) {
        var playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new AppException(ErrorCode.PLAYLIST_NOT_FOUND));

        if (!playlist.getOwnerId().equals(userId)) {
            throw new AppException(ErrorCode.PLAYLIST_NOT_FOUND);
        }

        playlistRepository.delete(playlist);
    }

    public PlaylistResponse updatePlaylist(String userId, String playlistId, PlaylistUpdateRequest updateRequest) {
        var playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new AppException(ErrorCode.PLAYLIST_NOT_FOUND));

        if (!playlist.getOwnerId().equals(userId)) {
            throw new AppException(ErrorCode.PLAYLIST_NOT_FOUND);
        }

        playlistMapper.updatePlaylist(playlist, updateRequest);

        var updatedPlaylist = playlistRepository.save(playlist);
        return playlistMapper.toPlaylistResponse(updatedPlaylist);
    }

    public PlaylistDetailResponse addSongToPlaylist(String userId, String playlistId, String songId) {
        var playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new AppException(ErrorCode.PLAYLIST_NOT_FOUND));

        if (!playlist.getOwnerId().equals(userId)) {
            throw new AppException(ErrorCode.PLAYLIST_NOT_FOUND);
        }

        var song = songRepository.findById(songId)
                .orElseThrow(() -> new AppException(ErrorCode.SONG_NOT_FOUND));

        if (!playlist.getSongs().contains(song)) {
            playlist.getSongs().add(song);
            playlist.setSongCount(playlist.getSongs().size());
        }

        var updatedPlaylist = playlistRepository.save(playlist);
        var response = playlistMapper.toPlaylistDetailResponse(updatedPlaylist);
        response.setSongs(updatedPlaylist.getSongs().stream()
                .map(songMapper::toSongResponse)
                .toList());
        return response;
    }

    public PlaylistDetailResponse removeSongFromPlaylist(String userId, String playlistId, String songId) {
        var playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new AppException(ErrorCode.PLAYLIST_NOT_FOUND));

        if (!playlist.getOwnerId().equals(userId)) {
            throw new AppException(ErrorCode.PLAYLIST_NOT_FOUND);
        }

        var song = songRepository.findById(songId)
                .orElseThrow(() -> new AppException(ErrorCode.SONG_NOT_FOUND));

        if (playlist.getSongs().contains(song)) {
            playlist.getSongs().remove(song);
            playlist.setSongCount(playlist.getSongs().size());
        }

        var updatedPlaylist = playlistRepository.save(playlist);
        var response = playlistMapper.toPlaylistDetailResponse(updatedPlaylist);
        response.setSongs(updatedPlaylist.getSongs().stream()
                .map(songMapper::toSongResponse)
                .toList());
        return response;
    }
}
