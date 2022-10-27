package com.poethan.swordwindapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {
        "com.poethan.gear",
        "com.poethan.swordwindmemcache",
        "com.poethan.swordwindapi"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SwordWindApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwordWindApiApplication.class, args);
    }

}
