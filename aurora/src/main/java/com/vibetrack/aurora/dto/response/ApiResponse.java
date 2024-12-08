package com.vibetrack.aurora.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL) // Include only non-null values in the response
public class ApiResponse<T> {
    @Builder.Default
    int code = 1000;

    String message;
    T result;
}

