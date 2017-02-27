package net.ukr.dreamsicle.io;

/**
 * Created by Yura on 27.02.2017.
 */
public class Validator {
    private Validator() {}

    public static boolean isLocalDate(double date) {
        return date >= 1 && date <= 31;
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

