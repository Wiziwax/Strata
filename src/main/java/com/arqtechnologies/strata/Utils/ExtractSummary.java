package com.arqtechnologies.strata.Utils;

import com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses.Route;
import com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionsMatrixResponse;

import java.util.ArrayList;
import java.util.List;

public class ExtractSummary {

    public static void main(String[] args) {
        DirectionsMatrixResponse response = getDirectionsMatrixResponse(); // Assuming you have a method to get the response

        List<String> summaries = extractSummaries(response);

        // Now, 'summaries' contains the list of strings extracted from the 'summary' property.
        for (String summary : summaries) {
            System.out.println(summary);
        }
    }

    private static List<String> extractSummaries(DirectionsMatrixResponse response) {
        List<String> summaries = new ArrayList<>();

        if (response != null && response.getRoutes() != null) {
            for (Route route : response.getRoutes()) {
                if (route != null && route.getSummary() != null) {
                    summaries.add(route.getSummary());
                }
            }
        }

        return summaries;
    }

    // This method is just for demonstration. You need to replace it with your actual method to get the DirectionsMatrixResponse.
    private static DirectionsMatrixResponse getDirectionsMatrixResponse() {
        // Implement the logic to get the DirectionsMatrixResponse
        // This might involve deserializing JSON or any other method of obtaining the response.
        return null; // Replace with the actual response
    }
}