package net.ukr.dreamsicle.trip;

import net.ukr.dreamsicle.joiner.Joiner;
import net.ukr.dreamsicle.tariff.Tariff;

import java.io.Serializable;

/**
 * Created by Yura on 13.02.2017.
 */
public class Trip implements Serializable, Entity {

    private static final long serialCersionUID = 1L;

    private final String city;
    private Transport transport;
    private final double localDate;
    private final Tariff tariff;

    public Trip(String city, Transport transport, double localDate, Tariff tariff) {
        this.city = city;
        this.transport = transport;
        this.localDate = localDate;
        this.tariff = tariff;
    }

    public String getCity() {
        return city;
    }

    public Transport getTransport() {
        return transport;
    }

    public double getLocalDate() {
        return localDate;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public long getPrice(){
        return tariff.calculatePrice(this);
    }

    @Override
    public String toString() {
        return  "City = " + city +
                ", Transport = " + transport +
                ", Date = " + localDate +
                ", tariff = " + getPrice() + "$";
    }

    public String toOutputString(String delimiter) {
        return new Joiner(delimiter).join(city, transport ,localDate, tariff);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (Double.compare(trip.localDate, localDate) != 0) return false;
        if (city != null ? !city.equals(trip.city) : trip.city != null) return false;
        if (transport != null ? !transport.equals(trip.transport) : trip.transport != null) return false;
        return tariff != null ? tariff.equals(trip.tariff) : trip.tariff == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = city != null ? city.hashCode() : 0;
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        temp = Double.doubleToLongBits(localDate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (tariff != null ? tariff.hashCode() : 0);
        return result;
    }
}
