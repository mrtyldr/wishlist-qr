package com.wusly.wishlistqr.domain;


import com.wusly.wishlistqr.core.Aggregate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "t_music_request")
public class MusicRequest extends Aggregate<UUID> {

    private UUID sessionId;
    private String title;
    private String artist;
    private Boolean accepted;

    public MusicRequest(UUID id, UUID sessionId, String title, String artist) {
        this.id = id;
        this.sessionId = sessionId;
        this.title = title;
        this.artist = artist;
        this.accepted = false;
    }

    public void accept() {
        this.accepted = true;
    }
}
