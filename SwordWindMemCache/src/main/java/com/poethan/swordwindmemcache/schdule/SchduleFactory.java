package com.poethan.swordwindmemcache.schdule;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SchduleFactory {
    private final static Logger logger = LoggerFactory.getLogger(SchduleFactory.class);
    private final static List<Schduler> schdulerList = new ArrayList<>();

    public static void add(Schduler schduler){
        schdulerList.add(schduler);
    }

    public static void run(){
        add(new HealthCheckJob());
        for(Schduler schduler : schdulerList){
            (new Thread(schduler::run, HealthCheckJob.class.getSimpleName())).start();
        }
        logger.debug("Schdule Start Success!");
    }
}
