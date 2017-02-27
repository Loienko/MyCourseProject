package net.ukr.dreamsicle.joiner;

import java.util.StringJoiner;

/**
 * Created by Yura on 26.02.2017.
 */
public class Joiner {
    private final String delimiter;

    public Joiner(String delimiter) {
        this.delimiter = delimiter;
    }

    public String join(Object... elms) {
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        for (Object elem : elms) {
            stringJoiner.add(elem.toString());
        }
        return stringJoiner.toString();
    }
}