package com.wusly.wishlistqr.domain;

import com.wusly.wishlistqr.core.Aggregate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "t_music")
@NoArgsConstructor
public class Music extends Aggregate<UUID> {
    String title;
    String artist;
    Double rating;


    public Music(UUID id, String title, String artist, Double rating) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.rating = rating;
    }
}
