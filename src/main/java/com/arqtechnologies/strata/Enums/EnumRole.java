package com.arqtechnologies.strata.Enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EnumRole {

//    @JsonProperty("DRIVER")
    DRIVER(0),
    PASSENGER(1),
    CUSTOMER_SERVICE(2),
    DEVELOPER(3),
    ADMIN(4),
    OTHER(5);



    private final int numericRating;

    EnumRole(int numericRating) {
        this.numericRating = numericRating;
    }

    public int getNumericValue() {
        return numericRating;
    }

    public static EnumRole fromNumericValue(int numericValue) {
        for (EnumRole value : EnumRole.values()) {
            if (value.getNumericValue() == numericValue) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid numeric value: " + numericValue);
    }

    public static EnumRole fromString(String text) {
        for (EnumRole value : EnumRole.values()) {
            if (value.name().equalsIgnoreCase(text)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid text: " + text);
    }

    public static int getNumericValueFromString(String text) {
        for (EnumRole value : EnumRole.values()) {
            if (value.name().equalsIgnoreCase(text)) {
                return value.getNumericValue();
            }
        }
        throw new IllegalArgumentException("Invalid text: " + text);
    }
}
