package net.ukr.dreamsicle.tariff;

import net.ukr.dreamsicle.trip.Trip;

/**
 * Created by Yura on 13.02.2017.
 */
public class StandartTrip implements Tariff {
    @Override
    public long calculatePrice(Trip trip) {
        return 90*56; //30+5*distance+2*duration+35*airline
    }
}
