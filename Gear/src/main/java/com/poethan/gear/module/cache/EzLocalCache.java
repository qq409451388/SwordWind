package com.poethan.gear.module.cache;

import com.poethan.gear.utils.DBC;
import com.poethan.gear.utils.SystemUtils;
import org.apache.logging.log4j.util.Strings;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class EzLocalCache {
    private final static ConcurrentHashMap<String, EzLocalCacheObject> data = new ConcurrentHashMap<>();
    private final static String EXCEPTION_PREFIX = "[EzLocalCache Exception] ";
    private final static String UNSUPPORT_COMMAND = EXCEPTION_PREFIX + "Unsupport Command %s From %s";

    private boolean has(String key) {
        return Objects.isNull(data.get(key));
    }

    private EzLocalCacheObject fetch(String key) {
        return data.get(key);
    }

    private void unsupportException(String key, int operateDataType, String funcName) {
        EzLocalCacheObject object = this.fetch(key);
        switch (operateDataType) {
            case EzLocalCacheObject.T_LIST:
                DBC.assertTrue(object.isList(), String.format(UNSUPPORT_COMMAND, funcName, object.getDataType()));
                break;
            case EzLocalCacheObject.T_MAP:
                DBC.assertTrue(object.isMap(), String.format(UNSUPPORT_COMMAND, funcName, object.getDataType()));
                break;
            case EzLocalCacheObject.T_STRING:
            case EzLocalCacheObject.T_INTEGER:
            case EzLocalCacheObject.T_FLOAT:
            default:
                DBC.assertTrue(object.isNormal(), String.format(UNSUPPORT_COMMAND, funcName, object.getDataType()));
                break;
        }
    }

    private boolean isExpire(String key) {
        if (!this.has(key)) {
            return true;
        }
        return this.fetch(key).isExpire();
    }

    public boolean exists(String key) {
        return this.has(key) && (!this.isExpire(key) || !this.del(key));
    }

    public boolean del (String key) {
        data.remove(key);
        return true;
    }

    public boolean expire (String key, int expire) {
        DBC.assertNonNull(this.fetch(key), EXCEPTION_PREFIX + "Expire No Match Key "+ key);
        this.fetch(key).setExpire(SystemUtils.currentTimeStamp() + expire);
        return true;
    }

    public boolean set (String key, String value) {
        data.put(key, EzLocalCacheObject.create(value));
        return true;
    }

    public boolean setEX(String key, String value, int expire) {
        data.put(key, EzLocalCacheObject.create(value, expire, EzLocalCacheObject.T_STRING));
        return true;
    }

    public String get(String key) {
        if (!this.exists(key)) {
            return Strings.EMPTY;
        }
        if (!this.fetch(key).isString()) {
            return Strings.EMPTY;
        }
        return (String) this.fetch(key).getDataSource();
    }

    public boolean flushAll () {
        data.clear();
        return true;
    }
}
