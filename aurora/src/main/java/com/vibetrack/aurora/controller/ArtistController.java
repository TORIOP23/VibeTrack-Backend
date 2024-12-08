package com.vibetrack.aurora.controller;

import com.vibetrack.aurora.dto.response.ApiResponse;
import com.vibetrack.aurora.dto.response.ArtistResponse;
import com.vibetrack.aurora.dto.response.PaginatedResponse;
import com.vibetrack.aurora.service.ArtistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
