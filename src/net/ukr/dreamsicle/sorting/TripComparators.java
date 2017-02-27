package net.ukr.dreamsicle.sorting;

import net.ukr.dreamsicle.trip.Trip;

import java.util.Comparator;

/**
 * Created by Yura on 22.02.2017.
 */
public class TripComparators {

    private TripComparators() {}

    public static Comparator<Trip> byDate() {
        return Comparator.comparingDouble(Trip::getLocalDate);
    }

    public static Comparator<Trip> byPrice() {
        return Comparator.comparingLong(Trip::getPrice);
    }

    public static Comparator<Trip> byCity() {
        return Comparator.comparing(Trip::getCity);
    }

}

