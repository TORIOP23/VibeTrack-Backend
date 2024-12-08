package com.vibetrack.aurora.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(2001, "Invalid key", HttpStatus.BAD_REQUEST),
    ALBUM_NOT_FOUND(2002, "Album not found", HttpStatus.NOT_FOUND),
    SQL_EXCEPTION(2003, "SQL exception occurred", HttpStatus.INTERNAL_SERVER_ERROR),
    ARTIST_NOT_FOUND(2004, "Artist not found", HttpStatus.NOT_FOUND);

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
