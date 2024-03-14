package com.poethan.sw.logic;

import com.poethan.jear.core.utils.JsonUtils;
import com.poethan.jear.web.tcp.SocketHandler;
import io.netty.channel.ChannelHandlerContext;

public class SwDispatch extends SocketHandler<byte[]> {
    @Override
    protected Class<byte[]> getMsgDataType() {
        return null;
    }

    @Override
    public void channelReadTrueType(ChannelHandlerContext ctx, byte[] msg) {
        String json = new String(msg).trim();
        System.out.println(json);
    }
}
