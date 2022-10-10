package com.poethan.gear.web;

import javax.websocket.*;

@ClientEndpoint()
public class WebSocketClientHandler {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("已连接，请输入要发送的信息：");
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Client收到的消息: " + message);
    }

    @OnClose
    public void onClose() {}
}
