package com.poethan.swordwindmemcache;

import com.poethan.gear.web.WebSocketServer;
import com.poethan.swordwindmemcache.schdule.SchduleFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class SwordWindMemServer extends WebSocketServer {
    public static void main(String[] args) {
        //1. 启动网络服务
        WebSocketServer webSocketServer = SwordWindMemServer.newInstance(6379);
        //2. 启动定时器任务
        SchduleFactory.run();
    }

    @Override
    public void callAfterMessageComeIn(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        System.out.println(frame.content());
    }
}
