package com.poethan.swordwindapi.api;

import com.poethan.gear.anno.EzLocalLog;
import com.poethan.gear.utils.SystemUtils;
import com.poethan.swordwinddata.vo.WebSocketClientVO;
import com.poethan.swordwindmemcache.knowledge.ClientContainer;
import com.poethan.swordwindmemcache.service.ClientService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@Component
@RestController
@RequestMapping("/chat")
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

    @EzLocalLog(EnableConsume = true)
    @GetMapping("/test")
    public String test(int a){
        SystemUtils.sleep(a * 1000);
        return "hello world!";
    }
}
