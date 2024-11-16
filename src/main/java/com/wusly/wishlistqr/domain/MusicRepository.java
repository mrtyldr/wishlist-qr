package com.wusly.wishlistqr.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MusicRepository extends JpaRepository<Music, UUID> {
    @Query("""
            select m from Music m
            inner join User u on m.userId = u.id
            where m.artist ilike :query
            or m.title ilike :query
            """)
    List<Music> search(String query);

    List<Music> findByUserId(@NotNull UUID id);

    Optional<Music> findByIdAndUserId(UUID id, @NotNull UUID userId);
}
