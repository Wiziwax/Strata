package com.arqtechnologies.strata.Entities.GeoCodingResponses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingResponse {

    private List<Results> results;
    private String status;


    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Results {

        @JsonProperty("address_components")
        private List<AddressComponent> addressComponents;

        @JsonProperty("formatted_address")
        private String formattedAddress;

        private Geometry geometry;
        private String placeId;
        private List<String> types;

        public void setAddressComponents(List<AddressComponent> addressComponents) {
            this.addressComponents = addressComponents;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AddressComponent {

        @JsonProperty("long_name")
        private String longName;

        @JsonProperty("short_name")
        private String shortName;

        private List<String> types;

        public void setLongName(String longName) {
            this.longName = longName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geometry {

        private Location location;
        private String locationType;
        private Viewport viewport;

        public void setLocation(Location location) {
            this.location = location;
        }

        public void setLocationType(String locationType) {
            this.locationType = locationType;
        }

        public void setViewport(Viewport viewport) {
            this.viewport = viewport;
        }
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {

        private double lat;
        private double lng;

        public void setLat(double lat) {
            this.lat = lat;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Viewport {

        private Location northeast;
        private Location southwest;

        public void setNortheast(Location northeast) {
            this.northeast = northeast;
        }

        public void setSouthwest(Location southwest) {
            this.southwest = southwest;
        }
    }
}