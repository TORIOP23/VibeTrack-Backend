package com.vibetrack.identity.entity;

import com.vibetrack.identity.constant.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(unique = true)
    String username;

    String password;
    String firstName;
    LocalDate dob;
    String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @Builder.Default
    Role role = Role.USER;
}
