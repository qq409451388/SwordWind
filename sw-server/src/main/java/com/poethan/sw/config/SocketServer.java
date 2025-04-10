package com.poethan.sw.config;

import com.corundumstudio.socketio.SocketIOServer;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: aichat
 * @BelongsPackage: com.rong360.aichat.conf
 * @Author: liulijun
 * @CreateTime: 2024-06-30  17:49
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@Component
public class SocketServer implements CommandLineRunner {
    @Autowired
    private  SocketIOServer socketIOServer;

    @Override
    public void run(String... args) {
        log.info("---------- starting ----------");
        socketIOServer.start();
        log.info("---------- start succ ----------");
    }

    @PreDestroy
    public void stop() {
        log.info("---------- stoping ----------");
        socketIOServer.stop();
        log.info("---------- stop succ ----------");
    }


}
