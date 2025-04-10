package com.poethan.sw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = SwServerApplication.BASE_PACKAGE)
@EnableScheduling
public class SwServerApplication {
    static final String BASE_PACKAGE = "com.poethan.sw";

    public static void main(String[] args) {
        SpringApplication.run(SwServerApplication.class, args);
    }
}