package com.wusly.wishlistqr.service;

import com.wusly.wishlistqr.controller.MusicController;
import com.wusly.wishlistqr.domain.Music;
import com.wusly.wishlistqr.domain.MusicRepository;
import com.wusly.wishlistqr.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final UserRepository userRepository;

    public void uploadMusic(MusicController.UploadMusicCommand command, String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
        musicRepository.save(new Music(
                UUID.randomUUID(),
                command.title(),
                command.artist(),
                0.0,
                user.getId()
        ));
    }
}
