package com.wusly.wishlistqr.domain;


import com.wusly.wishlistqr.core.Aggregate;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class MusicRequest extends Aggregate<UUID> {

    private UUID sessionId;
    private String title;
    private String artist;

    public MusicRequest(UUID id,UUID sessionId, String title, String artist) {
        this.id = id;
        this.sessionId = sessionId;
        this.title = title;
        this.artist = artist;
    }
}
