package com.poethan.gear.web;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public interface IEzWebSocketServerHandler extends ChannelHandler {
    void callAfterServerStarted();

    void callAfterChannelClose(ChannelHandlerContext ctx, CloseWebSocketFrame frame);

    void callAfterMessageComeIn(ChannelHandlerContext ctx, TextWebSocketFrame frame);
}
