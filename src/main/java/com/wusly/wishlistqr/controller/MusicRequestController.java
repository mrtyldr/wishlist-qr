package com.wusly.wishlistqr.controller;

import com.wusly.wishlistqr.controller.model.Response;
import com.wusly.wishlistqr.domain.MusicRepository;
import com.wusly.wishlistqr.domain.MusicRequestRepository;
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
    private final MusicService musicService;
    private final MusicRequestRepository musicRequestRepository;

    public record MusicResponse(
            UUID musicId,
            String artist,
            String title
    ) {
    }

    @GetMapping("/{sessionId}/search")
    public Response<List<MusicResponse>> searchMusic(@PathVariable UUID sessionId, @RequestParam(required = false) String query) {
        if (query == null || query.isBlank())
            return Response.of(musicRepository.findAll()
                    .stream()
                    .map(m -> new MusicResponse(m.getId(), m.getArtist(), m.getTitle()))
                    .toList()
            );
        return Response.of(musicRepository.search(query)
                .stream()
                .map(m -> new MusicResponse(m.getId(), m.getArtist(), m.getTitle()))
                .toList());
    }

    public record MusicRequestCommand(
            UUID musicId,
            String artist,
            String title
    ){

    }

    @PostMapping("/{sessionId}/request")
    public void requestMusic(@PathVariable UUID sessionId, @RequestBody MusicRequestCommand command) {
        musicService.requestMusic(sessionId, command);
    }
    public record MusicRequestResponse(
            String artist,
            String title){}

    @GetMapping("/{sessionId}/request")
    public Response<List<MusicRequestResponse>> getMusicRequests(@PathVariable UUID sessionId) {
        return Response.of(musicRequestRepository.findBySessionId(sessionId)
                .stream()
                .map(m -> new MusicRequestResponse(
                        m.getArtist(),
                        m.getTitle()
                )).toList());
    }
}
