package com.poethan.swordwindmemcache;

import com.poethan.gear.web.EzWebSocketServer;
import com.poethan.gear.web.EzWebSocketServerHandler;
import com.poethan.swordwindmemcache.schdule.SchduleFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class SwordWindMemServer extends EzWebSocketServer {
    public SwordWindMemServer(int port, Class<? extends EzWebSocketServerHandler> ez){
        super(port, ez);
    }

    public static void main(String[] args) {
        EzWebSocketServer ezWebSocketServer = new SwordWindMemServer(6379, SwordWindMemHandler.class);
        try {
            ezWebSocketServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void callAfterServerStart() {
        SchduleFactory.run();
    }

    public static class SwordWindMemHandler extends EzWebSocketServerHandler {

        @Override
        public void callAfterChannelStart(ChannelHandlerContext ctx, FullHttpRequest req) {

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
