package com.poethan.swordwindserver.vo;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class WebSocketClientVO {
    private String clientId;
    private String userName;
    private ChannelHandlerContext ctx;

    private boolean isDeleted;

    public WebSocketClientVO(String c, String u, ChannelHandlerContext handler){
        this.clientId = c;
        this.userName = u;
        this.ctx = handler;
        this.isDeleted = false;
    }

    public boolean check(){
        boolean isOpen = this.ctx.channel().isOpen();
        this.setDeleted(!isOpen);
        return isOpen;
    }
}
