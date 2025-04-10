package com.poethan.sw.config;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.AuthorizationResult;
import com.corundumstudio.socketio.HandshakeData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketAuthorizationListener implements AuthorizationListener {

    @Override
    public AuthorizationResult getAuthorizationResult(HandshakeData handshakeData) {
        String token = handshakeData.getSingleUrlParam("token");
        return new AuthorizationResult(true);
    }
}
