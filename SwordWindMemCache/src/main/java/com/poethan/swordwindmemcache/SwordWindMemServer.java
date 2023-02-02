package com.poethan.swordwindmemcache;

import com.poethan.gear.module.web.EzWebSocketServer;
import com.poethan.gear.module.web.EzWebSocketServerHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class SwordWindMemServer extends EzWebSocketServer {
    public SwordWindMemServer(int port, Class<? extends EzWebSocketServerHandler> ez){
        super(port, ez);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        EzWebSocketServer ezWebSocketServer = new SwordWindMemServer(6379, SwordWindMemHandler.class);
        String a = URLDecoder.decode("BXgGNwc1UDAHagg9ADZWNVU7BzlbagItULhQ9gLrCLAMiQGgV+JVzFvOUJdVK1AyVCM=", "UTF-8");
        System.out.println(a);
        try {
            ezWebSocketServer.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void callAfterServerStart() {
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
            ctx.channel().write("OK");
        }
    }
}
