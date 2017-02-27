package net.ukr.dreamsicle.tariff;

import net.ukr.dreamsicle.trip.Trip;

/**
 * Created by Yura on 13.02.2017.
 */
public interface Tariff {
    long calculatePrice(Trip trip);

}
