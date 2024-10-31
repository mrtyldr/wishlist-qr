package com.wusly.wishlistqr.controller;

import com.wusly.wishlistqr.domain.AuthenticationResponse;
import com.wusly.wishlistqr.domain.LoginCommand;
import com.wusly.wishlistqr.domain.RegisterUserCommand;
import com.wusly.wishlistqr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserCommand command) {
        userService.register(command);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginCommand command) {
        return userService.login(command);
    }

}
