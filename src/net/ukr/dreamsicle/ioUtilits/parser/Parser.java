package net.ukr.dreamsicle.ioUtilits.parser;

import net.ukr.dreamsicle.ioUtilits.IllegalFormatException;

/**
 * Created by Yura on 26.02.2017.
 */
public interface Parser <T> {
    T parse(String s) throws IllegalFormatException;
}
