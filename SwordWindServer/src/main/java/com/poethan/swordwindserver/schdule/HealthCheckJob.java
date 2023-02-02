package com.poethan.swordwindserver.schdule;

import com.poethan.gear.anno.EzSchdulerJob;
import com.poethan.gear.module.schduler.BaseSchduler;
import com.poethan.swordwindserver.knowledge.ClientContainer;
import lombok.extern.slf4j.Slf4j;

// TODO: 2022/10/10 SchdulerJob切面 启动时将此类加载到SchdulerFactory中
@EzSchdulerJob
@Slf4j
public class HealthCheckJob extends BaseSchduler {
    public void run() {
        if(ClientContainer.get().isEmpty()){
            log.info("Client Is Empty!");
            return;
        }
        ClientContainer.clearUnConnect();
        ClientContainer.forEach((k, v)->{
            if(!v.check()){
                log.info("Client:{} Is Closed!", k);
            }
        });
    }

    @Override
    public void initDelay() {
        this.delayMillis = 2000;
    }

    @Override
    public void initPeriod() {
        this.periodMillis = 2000;
    }
}
