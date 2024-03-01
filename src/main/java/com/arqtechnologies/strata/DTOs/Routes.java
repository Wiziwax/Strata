package com.arqtechnologies.strata.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Routes {

    private String pointA;
    private String pointB;
    private String pointC;
    private String pointD;
}
