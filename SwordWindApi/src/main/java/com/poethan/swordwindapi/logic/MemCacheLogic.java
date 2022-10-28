package com.poethan.swordwindapi.logic;

import com.poethan.swordwindmemcache.api.IMemCacheClient;
import com.poethan.swordwindmemcache.api.LocalCacheClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MemCacheLogic {
    @Value("${SwMemCache.ip}")
    private String ip;

    @Value("${SwMemCache.port}")
    private Integer port;
    private IMemCacheClient memCacheClient;

    public IMemCacheClient getMemCacheClient(){
        if(Objects.isNull(this.memCacheClient)){
            this.memCacheClient = new LocalCacheClient();
            this.memCacheClient.connect(this.ip, this.port);
        }
        return this.memCacheClient;
    }
}
