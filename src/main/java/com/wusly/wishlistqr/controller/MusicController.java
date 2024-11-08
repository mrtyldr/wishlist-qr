package com.wusly.wishlistqr.controller;

import com.wusly.wishlistqr.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/musics")
@RequiredArgsConstructor
@CrossOrigin
public class MusicController {
    private final MusicService musicService;

    public record UploadMusicCommand(
            String title,
            String artist
    ) {
    }

    @PostMapping
    public void uploadMusic(@RequestBody UploadMusicCommand command, Principal principal) {
        musicService.uploadMusic(command.title(), command.artist(), principal.getName());
    }
}
