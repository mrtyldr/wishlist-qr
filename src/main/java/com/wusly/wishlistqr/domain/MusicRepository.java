package com.wusly.wishlistqr.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MusicRepository extends JpaRepository<Music, UUID> {
    @Query("""
            select m from Music m
            inner join User u on m.userId = u.id
            where m.artist ilike :query
            or m.title ilike :query
            """)
    List<Music> search(String query);
}
