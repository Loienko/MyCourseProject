package net.ukr.dreamsicle.trip;

/**
 * Created by Yura on 13.02.2017.
 */
public enum Transport {
    BUS     ("Bus"),
    PLANE   ("Plane"),
    CAR     ("Car"),
    WALKER  ("Walker");

    private final String name;

    Transport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static boolean isTransport(String s) {
        for (Transport transport : Transport.values()) {
            if (transport.name().equals(s)) {
                return true;
            }
        }
        return false;
    }
}

