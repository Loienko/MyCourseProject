package net.ukr.dreamsicle.ioUtilits;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Yura on 26.02.2017.
 */
public interface ObjectWriter <T> extends Closeable {
    void write(T val) throws IOException;
}
