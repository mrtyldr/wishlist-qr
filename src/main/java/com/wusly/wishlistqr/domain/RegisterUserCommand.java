package com.wusly.wishlistqr.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterUserCommand(
        @Email
        String email,
        @NotNull @NotBlank
        String password,
        @NotNull @NotBlank
        String firstName,
        @NotNull @NotBlank
        String lastName,
        @NotNull @NotBlank
        String nickName
) {
}
