package com.wusly.wishlistqr.service;

import com.wusly.wishlistqr.controller.SessionController;
import com.wusly.wishlistqr.domain.Session;
import com.wusly.wishlistqr.domain.SessionRepository;
import com.wusly.wishlistqr.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public void createSession(SessionController.CreateSessionCommand command, String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("ss"));
        var session = new Session(
                UUID.randomUUID(),
                command.sessionName(),
                user.getId(),
                true
        );

        sessionRepository.save(session);
    }
}
