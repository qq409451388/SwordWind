package com.poethan.sw.handler;

import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventHandler {

    @OnConnect
    public void onConnect(SocketIOClient socketIOClient) {

    }

    @OnEvent("send_msg")
    public void onSendMsg(SocketIOClient socketIOClient, AckRequest ackRequest, String req) {
        System.out.println(req);
        socketIOClient.sendEvent("ack_msg", new AckCallback<String>(String.class, 10000) {
            @Override
            public void onSuccess(String result) {
                log.info("Ack received from server: " + result);
            }

        }, "ddd");
    }
}
