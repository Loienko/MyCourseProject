package net.ukr.dreamsicle.tariff;

import net.ukr.dreamsicle.trip.Trip;

/**
 * Created by Yura on 02.03.2017.
 */
public enum TariffEnum{

    ECONOMYTARIFF ("ECONOMY TARIFF"){
        public long calculatePrice(Tariff tariff){
            return (long)15*62;
        }
    } ,
    FAMILYTARIFF ("FAMILY TARIFF") {
        public long calculatePrice(Trip trip){
            return (long)15*62;
        }
    } ,
    LUXETARIFF ("LUXE TARIFF") {
        public long calculatePrice(Trip trip){
            return (long)15*62;
        }
    } ,
    STANDARTTARIFF ("STANDART TARIFF") {
        public long calculatePrice(Trip trip){
            return (long)15*62;
        }
    }
    ;

    private final String name;

    TariffEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static boolean isTariffEnum(String s) {
        for (TariffEnum tariffEnum : TariffEnum.values()) {
            if (tariffEnum.name().equals(s)) {
                return true;
            }
        }
        return false;
    }
}

