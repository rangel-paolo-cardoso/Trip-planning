package com.rangel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private LocalDateTime boarding;
    private String origin;
    private String destination;
    private int duration;

    private static final String format = "dd/MM/yyyy HH:mm:ss";

    /**
     * Constructor method that uses all the fields.
     * @param boarding
     * @param origin
     * @param destination
     * @param duration
     */
    public Time(String boarding, String origin, String destination, int duration) {
        this.boarding = LocalDateTime.parse(boarding, DateTimeFormatter.ofPattern(format));
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    /**
     * Returns the city name, given an array of type String containing the ZodeId.
     * @param splitZoneId array fo type String.
     * @return string representing the city name.
     */
    private String getCityName(String[] splitZoneId) {
        return splitZoneId[splitZoneId.length - 1];
    }

    /**
     * Returns the landing time at a certain destination.
     * @return an String value, representing the date and time.
     */
    public String returnTheLandingTimeConsideringTheDestinationLocation() {
        String[] timeZones = new String[ZoneId.getAvailableZoneIds().size()];
        ZoneId.getAvailableZoneIds().toArray(timeZones);

        int indexOriginTimeZone = 0;

        for (int i = 0; i < timeZones.length; i++) {
            if (getCityName(timeZones[i].split("/")).equals(origin)) {
                indexOriginTimeZone = i;
                break;
            }
        }

        String originTimeZone = timeZones[indexOriginTimeZone];
        ZoneId originTimeZoneId = ZoneId.of(originTimeZone);

        ZonedDateTime localTimeOrigin = this.boarding.atZone(originTimeZoneId);

        int indexDestinationTimeZone = 0;

        for (int i = 0; i < timeZones.length; i++) {
            if (getCityName(timeZones[i].split("/")).equals(destination)) {
                indexDestinationTimeZone = 1;
                break;
            }
        }

        String destinationTimeZone = timeZones[indexDestinationTimeZone];
        ZonedDateTime localTimeAtDestination = localTimeOrigin.withZoneSameInstant(ZoneId.of(destinationTimeZone));

        return localTimeAtDestination.plusHours(this.duration).format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * Returns the landing time considering the location of departure.
     * @return a string value, that represents the date and time.
     */
    public String returnTheLandingTimeConsidereingTheOriginLocation() {
        String[] timeZones = new String[ZoneId.getAvailableZoneIds().size()];
        ZoneId.getAvailableZoneIds().toArray(timeZones);

        int indexOriginTimeZone = 0;

        for (int i = 0; i < timeZones.length; i++) {
            if (timeZones[i].contains(destination)) {
                indexOriginTimeZone = i;
                break;
            }
        }

        String originTimeZone = timeZones[indexOriginTimeZone];
        ZoneId originTimeZoneId = ZoneId.of(originTimeZone);

        ZonedDateTime localTimeAtOrigin = this.boarding.atZone(originTimeZoneId);

        return localTimeAtOrigin.plusHours(this.duration).format(DateTimeFormatter.ofPattern(format));
    }
}
