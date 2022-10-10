package com.poethan.swordwindmemcache.api;

import com.poethan.gear.web.WebSocketClient;

public class LocalCacheClient implements IMemCacheClient {
    private WebSocketClient client;

    @Override
    public void connect(String ip, int port) {
        this.client = new WebSocketClient();
        this.client.connect(ip, port);
    }

    @Override
    public String get() {
        return "";
    }

    @Override
    public void set(String k, String v) {

    }
}