package net.ukr.dreamsicle.io;

/**
 * Created by Yura on 27.02.2017.
 */
public class Validator {
    private Validator() {}

    public static boolean isLocalDate(double date) {
        return date >= 1 && date <= 31;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

