package com.vibetrack.aurora.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PaginatedResponse<T>(Integer totalPages, List<T> content) {
}