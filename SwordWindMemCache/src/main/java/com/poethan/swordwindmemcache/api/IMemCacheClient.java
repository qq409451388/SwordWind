package com.poethan.swordwindmemcache.api;

public interface IMemCacheClient {
    void connect(String ip, int port);
    String get(String k);
    void set(String k, String v);
}
