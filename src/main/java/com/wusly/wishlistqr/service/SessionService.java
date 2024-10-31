package com.wusly.wishlistqr.service;

import com.wusly.wishlistqr.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public void createSession(CreateSessionCommand command, String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("ss"));
        if(sessionRepository.existsByUserIdAndActive(user.getId(), true))
            throw new RuntimeException("AlreadyExist!");
        var session = new Session(
                UUID.randomUUID(),
                command.sessionName(),
                user.getId(),
                true
        );

        sessionRepository.save(session);
    }

    public SessionDto getActiveSession(String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("ss"));

       return sessionRepository.findByUserIdAndActive(user.getId(), true)
                .map(s -> new SessionDto(s.getId(), s.getSessionName()))
                .orElseThrow(() -> new RuntimeException("ss"));
    }
}
