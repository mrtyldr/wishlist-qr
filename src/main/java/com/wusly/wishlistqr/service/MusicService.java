package com.wusly.wishlistqr.service;

import com.wusly.wishlistqr.controller.MusicController;
import com.wusly.wishlistqr.domain.Music;
import com.wusly.wishlistqr.domain.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public void uploadMusic(MusicController.UploadMusicCommand command) {
        musicRepository.save(new Music(
                UUID.randomUUID(),
                command.title(),
                command.artist(),
                0.0
        ));
    }
}
