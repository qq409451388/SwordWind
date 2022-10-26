package com.poethan.swordwindserver;

import com.poethan.gear.web.EzWebSocketServer;
import com.poethan.swordwindserver.web.SwordWindServerHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SwordWindServer {
    public static void main(String[] args){
        EzWebSocketServer ezWebSocketServer = EzWebSocketServer.newInstance(8100);
        ezWebSocketServer.setWebSocketServerHandler(new SwordWindServerHandler());
        try {
            ezWebSocketServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}