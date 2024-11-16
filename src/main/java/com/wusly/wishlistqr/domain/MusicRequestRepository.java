package com.wusly.wishlistqr.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MusicRequestRepository extends JpaRepository<MusicRequest, UUID> {
  List<MusicRequest> findBySessionIdAndAccepted(UUID sessionId, boolean b);
}