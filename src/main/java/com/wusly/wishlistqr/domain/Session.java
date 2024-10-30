package com.wusly.wishlistqr.domain;


import com.wusly.wishlistqr.core.Aggregate;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Session extends Aggregate<UUID> {

    private String sessionName;
    private UUID userId;
    private boolean active;

    public Session(UUID id,String sessionName, UUID userId, boolean active) {
        this.id = id;
        this.sessionName = sessionName;
        this.userId = userId;
        this.active = active;
    }
}
