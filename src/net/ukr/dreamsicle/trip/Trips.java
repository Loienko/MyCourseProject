package net.ukr.dreamsicle.trip;


import net.ukr.dreamsicle.tariff.Tariff;
import net.ukr.dreamsicle.filtering.Predicate;

import java.io.Serializable;
import java.util.*;



/**
 * Created by Yura on 13.02.2017.
 */
public class Trips implements Iterable<Trip>,Serializable {

    private static final long serialCersionUID = 1L;

    private final List<Trip> trips = new ArrayList<>();

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public long getPrice(Tariff tariff){ // total price for all trips
        long sum=0;
        for (Trip trip : trips) {
            sum +=tariff.calculatePrice(trip);
        }
        return sum;
    }


    public void sort(Comparator<Trip> comparator){
        Collections.sort(trips, comparator);
    }

    @Override
    public Iterator<Trip> iterator() {
        return trips.iterator();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Trip trip : trips) {
            joiner.add(trip.toString());
        }
        return joiner.toString();
    }

    public <T> Trips filter(Trips trips,Predicate<T> predicate) {
        Trips result = new Trips();

        for (Trip trip : trips) {
            if (predicate.apply((T) trip)) {
                result.addTrip(trip);
            }
        }

        return result;
    }

}
