package com.poethan.sw;

import com.poethan.jear.web.tcp.SocketHandler;
import com.poethan.jear.web.tcp.SocketServerConfigure;
import com.poethan.jear.web.tcp.SocketServerSimpleStarter;
import com.poethan.sw.logic.SwDispatch;
import org.springframework.stereotype.Component;

@Component
public class SwServerListener extends SocketServerSimpleStarter {
    @Override
    public SocketServerConfigure getConfigure() {
        return null;
    }

    @Override
    public Class<? extends SocketHandler<byte[]>> getSocketServerHandlerClazz() {
        return SwDispatch.class;
    }
}
