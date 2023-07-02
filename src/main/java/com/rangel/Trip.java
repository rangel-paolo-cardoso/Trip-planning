package com.rangel;

public class Trip {

    private String boarding;
    private String origin;
    private String destination;
    private double distanceKm;
    private Flight flight;

    /**
     * Constructor using all the fields.
     * @param boarding String that represents the date and time of the flight.
     * @param origin String, represents the origin location.
     * @param destination String, represents the destination.
     * @param distanceKm Double, the distance in kilometers.
     */
    public Trip(String boarding, String origin, String destination, Double distanceKm) {
        this.boarding = boarding;
        this.origin = origin;
        this.destination = destination;
        this.distanceKm = distanceKm;
        this.flight = new Flight();
    }

    /**
     * Returns the landing time at the destination.
     * @return string that represents the date and time.
     */
    public String returnTheLandingTimeConsideringTheDestinationLocation() {
        Time flightTime = new Time(
                this.boarding, this.origin, this.destination, this.returnFlightDuration());
        return flightTime.returnTheLandingTimeConsideringTheDestinationLocation();
    }

    /**
     * Retunrs the flight duration.
     * @return an int that represents the duration in hours.
     */
    public int returnFlightDuration() {
        return flight.returnFlightTime(distanceKm);
    }

    /**
     * Information about the flight.
     * @return string, containing details about the flight.
     */
    public String returnTriṕInformation() {
        Time tripTime = new Time(
                this.boarding, this.origin, this.destination, this.returnFlightDuration());
        StringBuilder description = new StringBuilder();
        description.append(
                this.flight.returnFlightInformation(
                        boarding,
                        origin,
                        tripTime.returnTheLandingTimeConsideringTheDestinationLocation(),
                        destination));

        description.append("\n\nAttention: disembarkation in ");
        description.append(this.destination);
        description.append(" will be: ");
        description.append(tripTime.returnTheLandingTimeConsideringTheDestinationLocation());
        description.append(" " + this.destination);
        description.append(" time and ");
        description.append(tripTime.returnTheLandingTimeConsidereingTheOriginLocation());
        description.append(" " + this.origin);
        description.append(" time ");

        return description.toString();
    }
}
