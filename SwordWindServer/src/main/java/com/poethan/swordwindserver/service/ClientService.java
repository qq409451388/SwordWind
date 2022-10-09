package com.poethan.swordwindserver.service;

import com.poethan.gear.utils.DBC;
import com.poethan.swordwindserver.knowledge.ClientContainer;
import com.poethan.swordwindserver.vo.WebSocketClientVO;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Service;

@Service
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
