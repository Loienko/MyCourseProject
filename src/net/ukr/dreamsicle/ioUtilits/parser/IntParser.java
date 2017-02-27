package net.ukr.dreamsicle.ioUtilits.parser;


import net.ukr.dreamsicle.ioUtilits.IllegalFormatException;

/**
 * Created by Yura on 26.02.2017.
 */
public class IntParser implements Parser<Integer> {
    @Override
    public Integer parse(String s) throws IllegalFormatException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalFormatException("can't parse string to int: " + s, e);
        }
    }
}
