package com.example.websockets_example.config;

import com.example.websockets_example.handler.FrameSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final FrameSocketHandler frameSocketHandler;

    public WebSocketConfig(FrameSocketHandler frameSocketHandler) {
        this.frameSocketHandler = frameSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(frameSocketHandler, "/ws/frames")
                .setAllowedOrigins("*");
    }
}