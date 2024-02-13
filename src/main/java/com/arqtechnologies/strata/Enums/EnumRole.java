package com.arqtechnologies.strata.Enums;

public enum EnumRole {

    DRIVER(1),
    PASSENGER(2),
    CUSTOMER_SERVICE(3),
    DEVELOPER(4),
    ADMIN(5),
    OTHER(6);



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
