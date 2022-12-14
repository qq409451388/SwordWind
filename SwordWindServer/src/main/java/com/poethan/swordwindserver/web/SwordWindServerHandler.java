package com.poethan.swordwindserver.web;

import com.poethan.gear.web.EzWebSocketServerHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class SwordWindServerHandler extends EzWebSocketServerHandler {
    @Override
    public void callAfterChannelStart(ChannelHandlerContext ctx, FullHttpRequest req) {

    }

    @Override
    public void callAfterChannelClose(ChannelHandlerContext ctx, CloseWebSocketFrame frame) {
        this.info(frame.reasonText());
    }

    @Override
    public void callAfterMessageComeIn(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        ctx.channel().write(new TextWebSocketFrame(dealRequest(frame.text())));
    }

    private String dealRequest(String request){
        return new java.util.Date().toString();
    }

}
