package com.poethan.swordwindmemcache.schdule;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class SchduleFactory {
    private final static List<Schduler> schdulerList = new ArrayList<>();

    public static void add(Schduler schduler){
        schdulerList.add(schduler);
    }

    public static void run(){
        for(Schduler schduler : schdulerList){
            log.info("Schdule {} Startting!", HealthCheckJob.class.getSimpleName());
            (new Thread(schduler::run, HealthCheckJob.class.getSimpleName())).start();
        }
        log.info("Schdule Start Success!");
    }
}
