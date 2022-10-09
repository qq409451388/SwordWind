package com.poethan.swordwindserver.knowledge;

import com.poethan.swordwindserver.vo.WebSocketClientVO;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ClientContainer {
    private final static Map<String, WebSocketClientVO> CLIENT_MAP = new HashMap<>();

    public static Map<String, WebSocketClientVO> get() {
        return CLIENT_MAP;
    }

    public static int size(){
        return CLIENT_MAP.size();
    }

    public static void forEach(BiConsumer<? super String, ? super WebSocketClientVO> bitConsumer){
        CLIENT_MAP.forEach(bitConsumer);
    }

    public static void markDelete(String key){
        CLIENT_MAP.get(key).setDeleted(true);
    }

    public static void clearUnConnect(){
        forEach((k, v)->{
            if(!v.isDeleted()){
                return;
            }
            CLIENT_MAP.remove(k);
        });
    }
}
