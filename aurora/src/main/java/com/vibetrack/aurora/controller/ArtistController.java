package com.vibetrack.aurora.controller;

import com.vibetrack.aurora.dto.response.ApiResponse;
import com.vibetrack.aurora.dto.response.ArtistDetailResponse;
import com.vibetrack.aurora.dto.response.ArtistResponse;
import com.vibetrack.aurora.dto.response.PaginatedResponse;
import com.vibetrack.aurora.service.ArtistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArtistController {
    ArtistService artistService;

    @GetMapping
    ApiResponse<PaginatedResponse<ArtistResponse>> getArtists(@ParameterObject Pageable pageable,
                                                              @RequestParam(defaultValue = "false") boolean unpaged) {
        var artists = artistService.getArtists(pageable, unpaged);
        return ApiResponse.<PaginatedResponse<ArtistResponse>>builder().result(artists).build();
    }

    @GetMapping("/search")
    ApiResponse<List<ArtistResponse>> getArtists(
            @RequestParam String name) {

        var artists = artistService.getArtistsByName(name);
        return ApiResponse.<List<ArtistResponse>>builder().result(artists).build();
    }

    @GetMapping("/{artistId}")
    ApiResponse<ArtistDetailResponse> getArtistById(@PathVariable String artistId) {
        var artist = artistService.getArtistById(artistId);
        return ApiResponse.<ArtistDetailResponse>builder().result(artist).build();
    }
}
