package net.ukr.dreamsicle.tariff;

import net.ukr.dreamsicle.trip.Trip;

/**
 * Created by Yura on 13.02.2017.
 */
public class LuxeTrip implements Tariff {

    @Override
    public long calculatePrice(Trip trip) {
        return 85*62; //50+5*distance+2*duration+50*airline+5*gold menu
    }
}
