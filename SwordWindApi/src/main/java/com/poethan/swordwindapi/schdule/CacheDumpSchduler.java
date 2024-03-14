package com.poethan.swordwindapi.schdule;

import com.poethan.gear.anno.EzSchdulerJob;
import com.poethan.gear.module.cache.EzLocalCache;
import com.poethan.gear.module.schduler.BaseSchduler;
import com.poethan.gear.utils.EncodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@EzSchdulerJob
@Component
public class CacheDumpSchduler extends BaseSchduler {
    @Resource
    private EzLocalCache ezLocalCache;

    @Override
    public void run() {
        log.info("EzLocalCacheInfo: {}", EncodeUtils.dump(ezLocalCache.getAll()));
    }

    @Override
    public void initDelay() {
        this.delayMillis = 1000;
    }

    @Override
    public void initPeriod() {
        this.periodMillis = 2000;
    }
}
