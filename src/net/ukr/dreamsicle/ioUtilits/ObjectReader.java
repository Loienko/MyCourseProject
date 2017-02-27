package net.ukr.dreamsicle.ioUtilits;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Yura on 26.02.2017.
 */
public interface ObjectReader<T> extends Closeable {
    T read() throws IOException, IllegalFormatException;
}
