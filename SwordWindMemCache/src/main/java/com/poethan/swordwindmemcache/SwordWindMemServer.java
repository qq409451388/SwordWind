package com.poethan.swordwindmemcache;

import com.poethan.gear.web.EzWebSocketServer;
import com.poethan.gear.web.EzWebSocketServerHandler;
import com.poethan.swordwindmemcache.schdule.SchduleFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class SwordWindMemServer extends EzWebSocketServer {
    public static void main(String[] args) {
        EzWebSocketServer ezWebSocketServer = SwordWindMemServer.newInstance(6379);
        ezWebSocketServer.setWebSocketServerHandler(new SwordWindMemHandler());
        try {
            ezWebSocketServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class SwordWindMemHandler extends EzWebSocketServerHandler {

        @Override
        public void callAfterServerStarted() {
            SchduleFactory.run();
        }

        @Override
        public void callAfterChannelClose(ChannelHandlerContext ctx, CloseWebSocketFrame frame) {

        }

        @Override
        public void callAfterMessageComeIn(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
            System.out.println(frame.content());
        }
    }
}
