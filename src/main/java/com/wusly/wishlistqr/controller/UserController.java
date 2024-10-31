package com.wusly.wishlistqr.controller;

import com.wusly.wishlistqr.domain.AuthenticationResponse;
import com.wusly.wishlistqr.service.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
            @Email
            String email,
            @NotNull@NotBlank
            String password,
            @NotNull@NotBlank
            String firstName,
            @NotNull@NotBlank
            String lastName,
            @NotNull@NotBlank
            String nickName
    ){}
    @PostMapping("/register")
    public void register(@RequestBody RegisterUserCommand command) {
        userService.register(command);
    }

    public record LoginCommand(String email, String password){
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginCommand command){
        return userService.login(command);
    }
}
