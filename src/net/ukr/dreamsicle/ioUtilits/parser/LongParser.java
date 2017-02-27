package net.ukr.dreamsicle.ioUtilits.parser;

import net.ukr.dreamsicle.ioUtilits.IllegalFormatException;

/**
 * Created by Yura on 26.02.2017.
 */
public class LongParser implements Parser<Long> {

    @Override
    public Long parse(String s) throws IllegalFormatException {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new IllegalFormatException("can't parse string to long: " + s, e);
        }
    }
}

