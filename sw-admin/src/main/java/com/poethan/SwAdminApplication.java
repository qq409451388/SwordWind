package com.poethan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = SwAdminApplication.BASE_PACKAGE)
@EnableScheduling
public class SwAdminApplication {
    static final String BASE_PACKAGE = "com.poethan.sw";

    public static void main(String[] args) {
        SpringApplication.run(SwAdminApplication.class, args);
    }
}
