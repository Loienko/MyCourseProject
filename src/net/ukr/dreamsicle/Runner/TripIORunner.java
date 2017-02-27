package net.ukr.dreamsicle.Runner;

import net.ukr.dreamsicle.io.IllegalFormatException;
import net.ukr.dreamsicle.trip.Trip;

import java.io.IOException;
import java.util.List;

import static net.ukr.dreamsicle.io.TripIOUtils.readTripsFromFile;
import static net.ukr.dreamsicle.io.TripIOUtils.writeTripsIntoBinFile;

/**
 * Created by Yura on 27.02.2017.
 */
public class TripIORunner {
    public static final String INPUT_TEXT_FILE = "files/films.csv";
    public static final String OUTPUT_BIN_FILE = "files/films.dat";

    public static void main(String[] args) {
        try {
            List<Trip> trips = readTripsFromFile(INPUT_TEXT_FILE);
            writeTripsIntoBinFile(OUTPUT_BIN_FILE, trips);
            System.out.println("DONE");
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
        }
    }
}

