package com.wusly.wishlistqr.domain;


import com.wusly.wishlistqr.core.Aggregate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "t_session")
public class Session extends Aggregate<UUID> {

    private String sessionName;
    private UUID userId;
    @Setter
    private boolean active;

    public Session(UUID id,String sessionName, UUID userId, boolean active) {
        this.id = id;
        this.sessionName = sessionName;
        this.userId = userId;
        this.active = active;
    }
}
