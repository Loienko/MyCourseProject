package net.ukr.dreamsicle.ioUtilits.parser;

/**
 * Created by Yura on 26.02.2017.
 */
public enum DsvFormat {
    CSV_COMMA(","),
    CSV_SEMICOLON(";"),
    TSV("\t");

    DsvFormat(String delimiter) {
        this.delimiter = delimiter;
    }

    private final String delimiter;

    public String getDelimiter() {
        return delimiter;
    }
}
