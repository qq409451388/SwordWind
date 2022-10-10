package com.poethan.swordwindmemcache;

import com.poethan.gear.web.WebSocketServer;
import com.poethan.swordwindmemcache.schdule.SchduleFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class SwordWindMemServer extends WebSocketServer {
    public static void main(String[] args) {
        WebSocketServer webSocketServer = SwordWindMemServer.newInstance(6379);
        try {
            webSocketServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void callAfterServerStarted() {
        SchduleFactory.run();
    }

    @Override
    public void callAfterMessageComeIn(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        System.out.println(frame.content());
    }
}
