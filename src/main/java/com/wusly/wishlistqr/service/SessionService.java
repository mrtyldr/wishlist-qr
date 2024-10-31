package com.wusly.wishlistqr.service;

import com.wusly.wishlistqr.domain.*;
import com.wusly.wishlistqr.error.NotFoundException;
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

    public void closeSession(UUID sessionId, String mail) {
        var user = userRepository.findByEmail(mail)
                .orElseThrow(() -> new RuntimeException("ss"));


        var session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("ss"));
        if(session.getUserId() != user.getId())
            throw new NotFoundException("session not found!!");

        session.setActive(false);
        sessionRepository.save(session);
    }
}
