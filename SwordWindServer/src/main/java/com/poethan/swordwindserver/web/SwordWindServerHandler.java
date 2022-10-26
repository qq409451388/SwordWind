package com.poethan.swordwindserver.web;

import com.poethan.gear.web.EzWebSocketServerHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class SwordWindServerHandler extends EzWebSocketServerHandler {
    @Override
    public void callAfterServerStarted() {

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
        return "欢迎使用Netty WebSocket服务，现在时刻：" + new java.util.Date();
    }

}
