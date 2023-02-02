package com.poethan.swordwindmemcache.api;

import com.poethan.swordwindmemcache.data.CommandEnum;
import com.poethan.swordwindmemcache.data.GetExecuter;
import com.poethan.swordwindmemcache.data.MemCacheData;
import com.poethan.swordwindmemcache.data.SetExecuter;
import com.poethan.swordwindmemcache.service.MemCacheWebSocketClient;

import java.util.Objects;

public class LocalCacheClient implements IMemCacheClient {
    private MemCacheWebSocketClient client;

    @Override
    public void connect(String ip, int port) {
        if(Objects.isNull(this.client)){
            this.client = new MemCacheWebSocketClient();
            this.client.connect(ip, port);
        }
    }

    @Override
    public String get(String k) {
        GetExecuter getExecuter = new GetExecuter();
        getExecuter.setKey(k);
        MemCacheData data = MemCacheData.builder().command(CommandEnum.GET).data(getExecuter).build();
        this.client.send(data);
        return "";
    }

    @Override
    public void set(String k, String v) {
        SetExecuter setExecuter = new SetExecuter();
        setExecuter.setKey(k);
        setExecuter.setValue(v);
        MemCacheData data = MemCacheData.builder().command(CommandEnum.SET).data(setExecuter).build();
        this.client.send(data);
    }
}