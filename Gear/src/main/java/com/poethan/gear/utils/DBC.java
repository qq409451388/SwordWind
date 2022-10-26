package com.poethan.gear.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class DBC {
    public static void assertTrue(boolean condition, String msg){
        if(!condition){
            log.error("[Gear] {}", msg);
            throw new RuntimeException(msg);
        }
    }

    public static void assertNonNull(Object obj, String msg){
        assertTrue(Objects.nonNull(obj), msg);
    }
}
