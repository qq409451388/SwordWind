package com.poethan.swordwindserver.api;

import com.poethan.swordwindserver.knowledge.ClientContainer;
import com.poethan.swordwindserver.service.ClientService;
import com.poethan.swordwindserver.vo.WebSocketClientVO;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController("/chat")
public class ChatApi {
    @Resource
    private ClientService clientService;

    @PostMapping("/sendToClient")
    public void sendToClient(String client, String msg){
        ChannelHandlerContext ctx = clientService.getChannelHandlerFromClientCode(client);
        ctx.channel().writeAndFlush(new TextWebSocketFrame(msg));
    }

    @GetMapping("/getAllClient")
    public String getAllClient(){
        Map<String, WebSocketClientVO> ms = ClientContainer.get();
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, WebSocketClientVO> entry : ms.entrySet()){
            sb.append(entry.getValue().toString()).append("<br/>");
        }
        return sb.toString();
    }
}
