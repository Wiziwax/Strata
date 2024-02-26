package com.arqtechnologies.strata.Utils;

import com.arqtechnologies.strata.Entities.Ride;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class RideEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public RideEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishRideChangeEvent(Ride ride) {
        RideChangeEvent event = new RideChangeEvent(ride);
        applicationEventPublisher.publishEvent(event);
    }
}
