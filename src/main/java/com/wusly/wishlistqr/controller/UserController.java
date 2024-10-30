package com.wusly.wishlistqr.controller;

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
    public record RegisterUserCommand(
            String email,
            String password,
            String firstName,
            String lastName,
            String nickName
    ){}
    @PostMapping("/register")
    public void register(@RequestBody RegisterUserCommand command) {
        userService.register(command);
    }

    public record LoginCommand(String email, String password){}
}
