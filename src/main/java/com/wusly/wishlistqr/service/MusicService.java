package com.wusly.wishlistqr.service;

import com.wusly.wishlistqr.controller.MusicController;
import com.wusly.wishlistqr.controller.MusicRequestController;
import com.wusly.wishlistqr.controller.model.Response;
import com.wusly.wishlistqr.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final UserRepository userRepository;
    private final MusicRequestRepository musicRequestRepository;

    public void uploadMusic(String title, String artist, String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
        musicRepository.save(new Music(
                UUID.randomUUID(),
                title,
                artist,
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

    public List<Music> getAll(String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
        return musicRepository.findByUserId(user.getId());
    }

    public void delete(UUID id, String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
        var music = musicRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(RuntimeException::new);
        musicRepository.delete(music);
    }
}
