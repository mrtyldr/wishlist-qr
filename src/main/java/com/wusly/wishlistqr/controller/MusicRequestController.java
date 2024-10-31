package com.wusly.wishlistqr.controller;

import com.wusly.wishlistqr.controller.model.Response;
import com.wusly.wishlistqr.domain.MusicRepository;
import com.wusly.wishlistqr.domain.UserRepository;
import com.wusly.wishlistqr.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/public/musics")
public class MusicRequestController {

    private final MusicRepository musicRepository;
    private final UserRepository userRepository;

    public record MusicResponse(
            UUID musicId,
            String artist,
            String title
    ) {
    }

    @GetMapping("/{sessionId}/search")
    public Response<List<MusicResponse>> searchMusic(@PathVariable UUID sessionId, String query) {
        return Response.of(musicRepository.search(query)
                .stream()
                .map(m -> new MusicResponse(m.getId(), m.getArtist(), m.getTitle()))
                .toList());
    }
}
