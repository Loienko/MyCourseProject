package net.ukr.dreamsicle.trip;

import net.ukr.dreamsicle.joiner.Joiner;
import net.ukr.dreamsicle.tariff.TariffEnum;

import java.io.Serializable;

/**
 * Created by Yura on 13.02.2017.
 */
public class Trip implements Serializable, Entity {

    private static final long serialCersionUID = 1L;

    private final String city;
    private Transport transport;
    private final double localDate;
    private final TariffEnum tariffEnum;

    public Trip(String city, Transport transport, double localDate, TariffEnum tariffEnum) {
        this.city = city;
        this.transport = transport;
        this.localDate = localDate;
        this.tariffEnum = tariffEnum;
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

    public TariffEnum getTariffEnum() {
        return tariffEnum;
    }

    public long getPrice(){
        return tariffEnum.compareTo (TariffEnum.ECONOMYTARIFF);
    }

    @Override
    public String toString() {
        return  "City = " + city +
                ", Transport = " + transport +
                ", Date = " + localDate +
                ", tariff = " + getPrice() + "$";
    }

    public String toOutputString(String delimiter) {
        return new Joiner(delimiter).join(city, transport ,localDate, tariffEnum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (Double.compare(trip.localDate, localDate) != 0) return false;
        if (city != null ? !city.equals(trip.city) : trip.city != null) return false;
        if (transport != trip.transport) return false;
        return tariffEnum == trip.tariffEnum;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = city != null ? city.hashCode() : 0;
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        temp = Double.doubleToLongBits(localDate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (tariffEnum != null ? tariffEnum.hashCode() : 0);
        return result;
    }
}
