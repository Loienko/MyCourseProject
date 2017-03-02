package net.ukr.dreamsicle.trip;

import net.ukr.dreamsicle.joiner.Joiner;
import net.ukr.dreamsicle.tariff.TariffEnum;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Yura on 13.02.2017.
 */
public class Trip implements Serializable, Entity {

    private static final long serialCersionUID = 1L;

    private final String city;
    private Set<Transport> transports = new TreeSet<>();
    private final double localDate;
    private Set<TariffEnum> tariffEnums = new TreeSet<>();

    public Trip(String city, Set<Transport> transports, double localDate, Set<TariffEnum> tariffEnums) {
        this.city = city;
        this.transports = transports;
        this.localDate = localDate;
        this.tariffEnums = tariffEnums;
    }

    public String getCity() {
        return city;
    }

    public Set<Transport> getTransports() {
        return transports;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

    public double getLocalDate() {
        return localDate;
    }

    public Set<TariffEnum> getTariffEnums() {
        return tariffEnums;
    }

    public void setTariffEnums(Set<TariffEnum> tariffEnums) {
        this.tariffEnums = tariffEnums;
    }

    public long getPrice(){
        return tariffEnums.add (this);
    }

    @Override
    public String toString() {
        return  "City = " + city +
                ", Transport = " + transport +
                ", Date = " + localDate +
                ", tariff = " + getPrice() + "$";
    }

    public String toOutputString(String delimiter) {
        return new Joiner(delimiter).join(city, transports ,localDate, tariffEnums);
    }


}
