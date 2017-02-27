package net.ukr.dreamsicle.filtering;

import net.ukr.dreamsicle.trip.Trip;

/**
 * Created by Yura on 26.02.2017.
 */
public class TripPredicates {

    private TripPredicates() {}

    public static Predicate<Trip> filterPrice(long maxPrice) {
        return elem -> elem.getPrice() < maxPrice ;
    }

    public static Predicate<Trip> filterCity(final String city) {
        return elem -> elem.getCity().contains(city);
    }

    public static Predicate<Trip> filterDate(final double minDate, final double maxDate) {
        return elem -> elem.getLocalDate() > minDate && elem.getLocalDate() <= maxDate;
    }
}
