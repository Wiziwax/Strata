package com.arqtechnologies.strata.Entities.GeoCodingResponses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistanceMatrixResponse {

    private List<String> destination_addresses;
    private List<String> origin_addresses;
    private List<Row> rows;
    private String status;



    @Getter
    @Setter
    public static class Row {
        private List<Element> elements;
    }


    @Getter
    @Setter
    public static class Element {

        private Distance distance;
        private Duration duration;
        private String status;

    }


    @Setter
    @Getter
    public static class Distance {

        private String text;
        private int value;
    }

    @Getter
    @Setter
    // Nested class representing 'duration' in the JSON
    public static class Duration {

        private String text;
        private int value;
    }
}
