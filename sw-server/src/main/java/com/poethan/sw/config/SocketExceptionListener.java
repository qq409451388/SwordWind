package com.poethan.sw.config;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ExceptionListener;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SocketExceptionListener implements ExceptionListener {

    @Override
    public void onEventException(Exception e, List<Object> list, SocketIOClient socketIOClient) {

        log.error("onEventException error {},message is {}",e.getMessage(),list, e);
        list.forEach(item->{
            log.info("list is item");
        });
    }

    @Override
    public void onDisconnectException(Exception e, SocketIOClient socketIOClient) {
        log.error("onDisconnectException error {}",e.getMessage(), e);
    }

    @Override
    public void onConnectException(Exception e, SocketIOClient socketIOClient) {
        log.error("onConnectException error {} socketIOClient is {}",e.getMessage(),socketIOClient, e);
    }

    @Override
    public void onPingException(Exception e, SocketIOClient socketIOClient) {
        log.error("onPingException error {}",e.getMessage(), e);
    }

    @Override
    public void onPongException(Exception e, SocketIOClient socketIOClient) {
        log.error("onPongException error {}",e.getMessage(), e);
    }

    @Override
    public boolean exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
        log.error("exceptionCaught error {}",throwable.getMessage(), throwable);
        channelHandlerContext.close();
        return false;
    }

    @Override
    public void onAuthException(Throwable throwable, SocketIOClient socketIOClient) {
        log.error("onAuthException error {}",throwable.getMessage(), throwable);
    }
}
