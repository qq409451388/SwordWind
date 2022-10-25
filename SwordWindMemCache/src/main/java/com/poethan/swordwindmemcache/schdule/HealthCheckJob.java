package com.poethan.swordwindmemcache.schdule;

import com.poethan.gear.anno.SchdulerJob;
import com.poethan.swordwindmemcache.knowledge.ClientContainer;
import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

// TODO: 2022/10/10 SchdulerJob切面 启动时将此类加载到SchdulerFactory中
@SchdulerJob
@Slf4j
public class HealthCheckJob implements Schduler {
    public void run() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
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
        };
        timer.scheduleAtFixedRate(timerTask, 0L, 2000);
    }
}
