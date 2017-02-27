package net.ukr.dreamsicle.tariff;

import net.ukr.dreamsicle.trip.Trip;

/**
 * Created by Yura on 13.02.2017.
 */
public class FamilyTrip implements Tariff {
    @Override
    public long calculatePrice(Trip trip) {
        return 15*62; //50+25*distance+10*airline*passengers
    }

}
