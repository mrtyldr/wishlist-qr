package com.wusly.wishlistqr.controller;

import com.wusly.wishlistqr.service.MusicService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/musics")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MusicController {
    private final MusicService musicService;

    public record UploadMusicCommand(
            String title,
            String artist
    ) {
    }

    @PostMapping
    public void uploadMusic(@RequestBody UploadMusicCommand command) {
        musicService.uploadMusic(command);
    }
}
