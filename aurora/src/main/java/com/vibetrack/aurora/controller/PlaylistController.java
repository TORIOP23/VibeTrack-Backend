package com.vibetrack.aurora.controller;

import com.vibetrack.aurora.dto.request.PlaylistUpdateRequest;
import com.vibetrack.aurora.dto.response.ApiResponse;
import com.vibetrack.aurora.dto.response.PlaylistDetailResponse;
import com.vibetrack.aurora.dto.response.PlaylistResponse;
import com.vibetrack.aurora.service.PlaylistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PlaylistController {
    PlaylistService playlistService;

//    @GetMapping
//    public String getPlaylists(
//            @RequestHeader("X-User-Id") String userId
//    ) {
//        return "User ID: " + userId;
//    }

    @PostMapping
    public ApiResponse<PlaylistResponse> createPlaylist(@RequestHeader("X-User-Id") String userId) {
        var playlist = playlistService.createPlaylist(userId);
        return ApiResponse.<PlaylistResponse>builder().result(playlist).build();
    }

    @GetMapping
    public ApiResponse<List<PlaylistResponse>> getPlaylists(@RequestHeader("X-User-Id") String userId) {
        var playlists = playlistService.getPlaylists(userId);
        return ApiResponse.<List<PlaylistResponse>>builder().result(playlists).build();
    }

    @GetMapping("/{playlistId}")
    public ApiResponse<PlaylistDetailResponse> getPlaylistDetail(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable String playlistId
    ) {
        var playlist = playlistService.getPlaylistDetail(userId, playlistId);
        return ApiResponse.<PlaylistDetailResponse>builder().result(playlist).build();
    }

    @PutMapping("/{playlistId}")
    public ApiResponse<PlaylistResponse> updatePlaylist(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable String playlistId,
            @RequestBody PlaylistUpdateRequest updateRequest
    ) {
        var updatedPlaylist = playlistService.updatePlaylist(userId, playlistId, updateRequest);
        return ApiResponse.<PlaylistResponse>builder().result(updatedPlaylist).build();
    }

    @PutMapping("/{playlistId}/add/{songId}")
    public ApiResponse<PlaylistDetailResponse> addSongToPlaylist(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable String playlistId,
            @PathVariable String songId
    ) {
        var playlist = playlistService.addSongToPlaylist(userId, playlistId, songId);
        return ApiResponse.<PlaylistDetailResponse>builder().result(playlist).build();
    }

    @PutMapping("/{playlistId}/remove/{songId}")
    public ApiResponse<PlaylistDetailResponse> removeSongFromPlaylist(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable String playlistId,
            @PathVariable String songId
    ) {
        var playlist = playlistService.removeSongFromPlaylist(userId, playlistId, songId);
        return ApiResponse.<PlaylistDetailResponse>builder().result(playlist).build();
    }


    @DeleteMapping("/{playlistId}")
    public ApiResponse<String> deletePlaylist(
            @RequestHeader("X-User-Id") String userId,
            @PathVariable String playlistId
    ) {
        playlistService.deletePlaylist(userId, playlistId);
        return ApiResponse.<String>builder().result("Playlist deleted").build();
    }
}
