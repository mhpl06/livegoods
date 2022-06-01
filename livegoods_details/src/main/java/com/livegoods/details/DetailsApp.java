package com.livegoods.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DetailsApp {
    public static void main(String[] args) {
        SpringApplication.run(DetailsApp.class, args);
    }
}
