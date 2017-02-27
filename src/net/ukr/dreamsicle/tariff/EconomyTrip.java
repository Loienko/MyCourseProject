package net.ukr.dreamsicle.tariff;

import net.ukr.dreamsicle.trip.Trip;

/**
 * Created by Yura on 13.02.2017.
 */
public class EconomyTrip implements Tariff {
    @Override
    public long calculatePrice(Trip trip) {
        return (long)15*62; //25+5*distance+2*duration+15*airline
    }
}
