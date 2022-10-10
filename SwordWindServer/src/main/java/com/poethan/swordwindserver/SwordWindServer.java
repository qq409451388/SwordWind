package com.poethan.swordwindserver;

import com.poethan.gear.web.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
public class SwordWindServer {
    public static void run(){
        WebSocketServer webSocketServer = WebSocketServer.newInstance(8100);
        try {
            webSocketServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}