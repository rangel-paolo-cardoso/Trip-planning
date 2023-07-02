package com.rangel;

public class Flight {

    private int flightTime;

    /**
     * Returns the flight time in hours.
     * @param ditanceKm a double value that represents the distance in kilometers.
     * @return an int value, which is the rounded down.
     */
    public int returnFlightTime(double ditanceKm) {
        Double durationDouble = ditanceKm / 700.0;
        flightTime = (int) Math.floor(durationDouble);
        return flightTime;
    }

    public String returnFlightInformation(
            String boarding, String origin, String disembarkation, String destination) {
        StringBuilder description = new StringBuilder();
        description.append("Departure: ");
        description.append(boarding);
        description.append("\nOrigin: ");
        description.append(origin);
        description.append("\n");
        description.append("\nArrival: ");
        description.append(disembarkation);
        description.append("\nDestination: ");
        description.append(destination);
        return "";
    }
}
