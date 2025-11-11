package com.example.websockets_example.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
public class FrameGeneratorService {
    private final Random random = new Random();

    public byte[] generateMockFrame() throws IOException {
        byte[] fakeFrame = new byte[1024 * 1024]; // 1MB grayscale
        random.nextBytes(fakeFrame);
        return fakeFrame;
    }
}
