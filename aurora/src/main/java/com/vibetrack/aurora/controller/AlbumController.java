package com.vibetrack.aurora.controller;

import com.vibetrack.aurora.dto.response.AlbumDetailResponse;
import com.vibetrack.aurora.dto.response.AlbumResponse;
import com.vibetrack.aurora.dto.response.ApiResponse;
import com.vibetrack.aurora.dto.response.PaginatedResponse;
import com.vibetrack.aurora.service.AlbumService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AlbumController {

    AlbumService albumService;

    @GetMapping("/search")
    ApiResponse<List<AlbumResponse>> getAlbums(
            @RequestParam String name
    ) {
        var albums = albumService.getAlbumsByName(name);
        return ApiResponse.<List<AlbumResponse>>builder().result(albums).build();
    }

    @GetMapping
    ApiResponse<PaginatedResponse<AlbumResponse>> getAlbums(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "false") boolean unpaged
    ) {
        var albums = albumService.getAlbums(pageable, unpaged);
        return ApiResponse.<PaginatedResponse<AlbumResponse>>builder().result(albums).build();
    }

    @GetMapping("/{albumId}")
    ApiResponse<AlbumDetailResponse> getAlbum(@PathVariable String albumId) {
        var album = albumService.getAlbumById(albumId);
        return ApiResponse.<AlbumDetailResponse>builder().result(album).build();
    }
}
