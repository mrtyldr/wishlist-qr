package com.wusly.wishlistqr.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {

    boolean existsByUserIdAndActive(@NotNull UUID id, boolean active);

    Optional<Session> findByUserIdAndActive(@NotNull UUID id, boolean active);
}
