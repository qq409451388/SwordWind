package com.poethan.swordwindserver;

import org.springframework.boot.SpringApplication;

//@SpringBootApplication
//@EnableScheduling
public class SwordWindWebApplication extends SpringApplication {
    public static void main(String[] args) throws Exception {
        //SpringApplication.run(SwordWindWebApplication.class, args);
        SwordWindServer.run();
    }
}
