package com.poethan.swordwindserver;

import com.poethan.gear.web.WebSocketServer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SwordWindServer {
    public static void main(String[] args){
        WebSocketServer webSocketServer = WebSocketServer.newInstance(8100);
        try {
            webSocketServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}