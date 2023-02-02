package com.poethan.swordwindmemcache.service;

import com.poethan.gear.utils.JsonUtils;
import com.poethan.gear.module.web.WebSocketClient;
import com.poethan.swordwindmemcache.data.MemCacheData;

public class MemCacheWebSocketClient extends WebSocketClient {
    public void send(MemCacheData data){
        this.send(JsonUtils.encode(data));
    }
}
