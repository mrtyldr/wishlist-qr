package com.wusly.wishlistqr.controller;
//POST database insert işlemleri
//PUT database datasını update ediceksek
//GET database den veri çekiceksek
//PATCH Parametre almayan tek bir işlevi olan ve omnipotent
//DELETE databaseden silmek için
import com.wusly.wishlistqr.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/sessions")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    public record CreateSessionCommand(
            String sessionName
    ){

    }
    @PostMapping
    public void createSession(@RequestBody CreateSessionCommand command, Principal principal) {
        sessionService.createSession(command, principal.getName());
    }

}
