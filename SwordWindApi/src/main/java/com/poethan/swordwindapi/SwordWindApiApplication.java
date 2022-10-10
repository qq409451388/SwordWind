package com.poethan.swordwindapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.poethan.swordwindmemcache",
        "com.poethan.swordwindapi"
})
public class SwordWindApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwordWindApiApplication.class, args);
    }

}
