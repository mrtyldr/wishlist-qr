package com.wusly.wishlistqr.service;

import com.wusly.wishlistqr.domain.*;
import com.wusly.wishlistqr.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public void register(RegisterUserCommand command) {
        var user = new User(UUID.randomUUID(),
                command.email(),
                passwordEncoder.encode(command.password()),
                command.firstName(),
                command.lastName(),
                command.nickName()
        );

        userRepository.save(user);
    }



    public AuthenticationResponse login(LoginCommand command){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        command.email(),
                        command.password()
                )
        );
        var user = userRepository.findByEmail(command.email())
                .orElseThrow(() -> new RuntimeException("ss"));


        return new AuthenticationResponse(
                jwtService.generateToken(user)
        );
    }
}
