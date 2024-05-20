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
    //TODO USE MAPPING FOR EVERYTHING THAT INVOLVES LOOPING
    //TODO DECIDE WHETHER TO MERGE RIDER TO DRIVER'S RIDE TABLE OR RIDER SHOULD CREATE HIS OWN RIDE

    //TODO DO WE PRACTICE BROADCASTING OR THE PASSENGER PICKS THE DRIVER WHOM HE INTENDS TO FOLLOW
}
