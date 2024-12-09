package com.vibetrack.aurora.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "playlist_id")
    String playlistId;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "owner_id")
    String ownerId;

    @Column(name = "image_url")
    String imageUrl;

    @ManyToMany
    @JoinTable(
            name = "playlist_songs",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    List<Song> songs;

    @Transient // This field will not be persisted in the database
    int songCount;

    public int getSongCount() {
        if (songs == null) {
            return 0;
        }
        return songs.size();
    }
}
