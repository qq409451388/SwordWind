package com.poethan.swordwindapi.api;

import com.poethan.gear.anno.EzApiCache;
import com.poethan.gear.anno.EzLocalLog;
import com.poethan.gear.module.EzRpcResponse;
import com.poethan.gear.utils.SystemUtils;
import com.poethan.swordwindapi.logic.MemCacheLogic;
import com.poethan.swordwindapi.logic.TempLogic;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Component
@RestController
@RequestMapping("/chat")
public class ChatApi {
    @Resource
    private MemCacheLogic cacheLogic;

/*    @PostMapping("/sendToClient")
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
    }*/

    @EzLocalLog(EnableConsume = true)
    @GetMapping("/test")
    public String test(int a){
        SystemUtils.sleep(a * 1000);
        return "hello world!";
    }

    @GetMapping("/cache")
    public void cache(){
        cacheLogic.getMemCacheClient().set(SystemUtils.getTraceId(), SystemUtils.getTraceId());
    }

    @Resource
    private TempLogic tempLogic;

    @GetMapping("/push")
    public void push(String m) {
        tempLogic.publish(m, "order.direct", "test.routingkey");
    }

    @EzLocalLog(EnableConsume = true)
    @GetMapping("/getList")
    public EzRpcResponse getList() {
        return EzRpcResponse.OK(tempLogic.getList("qq", "wechat", 23));
    }
}
