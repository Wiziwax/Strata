package com.arqtechnologies.strata.Utils;

import com.arqtechnologies.strata.Entities.Ride;
import org.springframework.context.ApplicationEvent;

public class RideChangeEvent extends ApplicationEvent {

    public RideChangeEvent(Ride source) {
        super(source);
    }
}
