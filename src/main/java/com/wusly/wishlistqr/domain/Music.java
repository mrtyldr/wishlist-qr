package com.wusly.wishlistqr.domain;

import com.wusly.wishlistqr.core.Aggregate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "t_music")
@NoArgsConstructor
@Getter
public class Music extends Aggregate<UUID> {
    private String title;
    private String artist;
    private Double rating;
    private UUID userId;


    public Music(UUID id, String title, String artist, Double rating, UUID userId) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.rating = rating;
    }
}
