package com.wusly.wishlistqr.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.wusly.wishlistqr.domain.CreateSessionCommand;
import com.wusly.wishlistqr.domain.SessionDto;
import com.wusly.wishlistqr.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.security.Principal;

@RestController
@RequestMapping("/api/v1/sessions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SessionController {
    private final SessionService sessionService;
    @Value("${deployment.url}")
    private String deploymentUrl;

    @PostMapping
    public void createSession(@RequestBody CreateSessionCommand command, Principal principal) {
        sessionService.createSession(command, principal.getName());
    }

    @GetMapping("/active")
    public SessionDto getActiveSession(Principal principal) {
        return sessionService.getActiveSession(principal.getName());
    }

    @GetMapping("{sessionId}/qr")
    public BufferedImage getQr(@PathVariable String sessionId) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode("%s/public/%s".formatted(deploymentUrl, sessionId),
                    BarcodeFormat.QR_CODE, 200, 200);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new RuntimeException("Barcode creation couldn't complete!!", e);
        }
    }
}
