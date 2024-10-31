package com.wusly.wishlistqr.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MusicRepository extends JpaRepository<Music, UUID> {
}
