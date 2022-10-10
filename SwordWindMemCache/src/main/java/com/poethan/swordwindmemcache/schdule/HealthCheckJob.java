package com.poethan.swordwindmemcache.schdule;

import com.poethan.gear.anno.SchdulerJob;
import com.poethan.swordwindmemcache.knowledge.ClientContainer;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

// TODO: 2022/10/10 SchdulerJob切面 启动时将此类加载到SchdulerFactory中
@SchdulerJob
public class HealthCheckJob implements Schduler {
    private final Logger logger = LoggerFactory.getLogger(HealthCheckJob.class);
    public void run() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(ClientContainer.get().isEmpty()){
                    logger.warn("Client Is Empty!");
                    return;
                }
                ClientContainer.clearUnConnect();
                ClientContainer.forEach((k, v)->{
                    if(!v.check()){
                        logger.debug("Client:{} Is Closed!", k);
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0L, 2000);
    }
}
