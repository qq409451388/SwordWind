package com.poethan.swordwindserver.schdule;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SchduleFactory {
    private static List<Schduler> schdulerList;

    public static void add(Schduler schduler){
        schdulerList.add(schduler);
    }

    public static void run(){
        for(Schduler schduler : schdulerList){
            (new Thread(schduler::run, HealthCheckJob.class.getSimpleName())).start();
        }
        log.info("Schdule Start Success!");
    }
}
