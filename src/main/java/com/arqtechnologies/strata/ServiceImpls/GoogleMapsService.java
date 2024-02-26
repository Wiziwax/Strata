package com.arqtechnologies.strata.ServiceImpls;


import com.arqtechnologies.strata.Entities.GeoCodingResponses.DistanceMatrixResponse;
import com.arqtechnologies.strata.Entities.GeoCodingResponses.GeocodingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapsService {

    @Value("${google.maps.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GoogleMapsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GeocodingResponse getGeocodingData(String address) {
        String apiUrl = "https://maps.googleapis.com/maps/api/geocode/json";
        String url = String.format("%s?address=%s&key=%s", apiUrl, address, apiKey);

        GeocodingResponse geocodingResponse = restTemplate.getForObject(url, GeocodingResponse.class);

        assert geocodingResponse != null;
        return restTemplate.getForObject(url, GeocodingResponse.class);
    }



    //TODO OPEN UP FOR OTHER LANGUAGES
    public DistanceMatrixResponse getDistanceMatrix(String origin, String destination){

        String apiUrl="https://maps.googleapis.com/maps/api/distancematrix/json";
        String url= String.format("%s?destinations=%s&mode=driving&origins=%s&language=en-EN&key=%s", apiUrl, destination, origin, apiKey);
        System.out.println(url);
        return restTemplate.getForObject(url, DistanceMatrixResponse.class);
    }
}
