package com.arqtechnologies.strata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class StrataApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrataApplication.class, args);
    }

    //TODO MOVE ALL THE ENUMS TO STATIC DATA

}
