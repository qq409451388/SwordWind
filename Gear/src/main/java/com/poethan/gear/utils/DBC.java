package com.poethan.gear.utils;

import java.util.Objects;

public class DBC {
    public static void assertTrue(boolean condition, String msg){
        if(!condition){
            throw new RuntimeException(msg);
        }
    }

    public static void assertNonNull(Object obj, String msg){
        assertTrue(Objects.nonNull(obj), msg);
    }
}
