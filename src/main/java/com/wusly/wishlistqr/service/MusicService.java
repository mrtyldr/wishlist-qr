package com.wusly.wishlistqr.service;

import com.wusly.wishlistqr.controller.MusicController;
import com.wusly.wishlistqr.controller.MusicRequestController;
import com.wusly.wishlistqr.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final UserRepository userRepository;
    private final MusicRequestRepository musicRequestRepository;

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

    public void requestMusic(UUID sessionId, MusicRequestController.MusicRequestCommand command) {
        if (command.musicId() != null) {
            var music = musicRepository.findById(command.musicId())
                    .orElseThrow(RuntimeException::new);
            musicRequestRepository.save(new MusicRequest(
                    UUID.randomUUID(),
                    sessionId,
                    music.getArtist(),
                    music.getTitle()
            ));
        } else
            musicRequestRepository.save(new MusicRequest(
                    UUID.randomUUID(),
                    sessionId,
                    command.artist(),
                    command.title()
            ));
    }
}
