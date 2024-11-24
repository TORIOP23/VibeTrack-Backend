package com.vibetrack.identity.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // Lombok annotation to create all fields as private
public class AuthenticationRequest {
    String username;
    String password;
}
