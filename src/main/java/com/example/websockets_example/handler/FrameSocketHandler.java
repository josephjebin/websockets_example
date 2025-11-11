package com.example.websockets_example.handler;

import com.example.websockets_example.service.FrameGeneratorService;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class FrameSocketHandler extends BinaryWebSocketHandler {

    private final FrameGeneratorService frameGeneratorService;
    private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    public FrameSocketHandler(FrameGeneratorService frameGeneratorService) {
        this.frameGeneratorService = frameGeneratorService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        System.out.println("Client connected: " + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
        System.out.println("Client disconnected: " + session.getId());
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        // This handles incoming binary data from the client (if needed)
        System.out.println("Received binary message: " + message.getPayloadLength() + " bytes");
        broadcastFrame(session, frameGeneratorService.generateMockFrame());
    }

    public void broadcastFrame(WebSocketSession session, byte[] data) throws IOException {
        BinaryMessage message = new BinaryMessage(data);
        System.out.println("Sending binary message: " + message + " bytes");
        session.sendMessage(message);
    }
}
