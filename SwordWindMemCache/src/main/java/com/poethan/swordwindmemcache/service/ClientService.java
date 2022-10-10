package com.poethan.swordwindmemcache.service;

import com.poethan.gear.utils.DBC;
import com.poethan.swordwinddata.vo.WebSocketClientVO;
import com.poethan.swordwindmemcache.knowledge.ClientContainer;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

@Component
public class ClientService {

    public ChannelHandlerContext getChannelHandlerFromClientCode(String clientCode){
        return null;
    }

    public static void save(ChannelHandlerContext c){
        ClientContainer.get().put(c.channel().id().asLongText(), new WebSocketClientVO(c.channel().id().asLongText(), "", c));
        //todo userName临时更新逻辑
        updateUserName(c, String.valueOf(ClientContainer.size()));
    }

    public static void updateUserName(ChannelHandlerContext c, String userName){
        WebSocketClientVO webSocketClientVO = ClientContainer.get().get(c.channel().id().asLongText());
        DBC.assertNonNull(webSocketClientVO, "Client Is Null!");
        webSocketClientVO.setUserName(userName);
    }

    public static void close(ChannelHandlerContext c){
        ClientContainer.markDelete(c.channel().id().asLongText());
    }
}
