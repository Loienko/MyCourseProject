package net.ukr.dreamsicle.io;

import net.ukr.dreamsicle.trip.Trip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static net.ukr.dreamsicle.io.Validator.isDouble;
import static net.ukr.dreamsicle.io.Validator.isLocalDate;

/**
 * Created by Yura on 27.02.2017.
 */
public class TripIOUtils {
    private TripIOUtils() {}

    public static final String CSV_DELIMITER = ";";

    // Input from text file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Trip> readTripsFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readTrips(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Trip> readTrips(BufferedReader reader) throws IOException {
        List<Trip> res = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            Trip trip = parseTrip(line);
            res.add(trip);
        }

        return res;
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Trip readTripFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readTrip(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Trip readTrip(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return parseTrip(line);
    }

    // Output into text file

    public static void writeTripsIntoFile(String fileName, List<Trip> trips) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writeTrips(writer, trips);
        }
    }

    public static void writeTrips(PrintWriter writer, List<Trip> trips) {
        for (Trip trip : trips) {
            writer.println(trip.toOutputString(CSV_DELIMITER));
        }
    }

    // Output into binary file

    public static void writeTripsIntoBinFile(String fileName, List<Trip> trips) throws IOException {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutput.writeObject(trips);
        }
    }

    // Input from binary file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Trip> readTripsFromBinFile(String fileName) throws IOException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Trip>)objectInput.readObject();
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IllegalFormatException("Binary file is corrupted", e);
        }
    }

    // Common

    /**
     * @throws IllegalFormatException
     */
    public static Trip parseTrip(String line) {
        String[] tokens = line.split(CSV_DELIMITER);

        if (tokens.length < 3) {
            throw new IllegalFormatException("Missing values, should be (city; transport: date: tariff): " + line);
        }
        if (!isDouble(tokens[1])) {
            throw new IllegalFormatException("Release year in not a number: " + tokens[1]);
        }

        String city = tokens[0].trim();
        String transport = tokens[0].trim();
        int localDate = Integer.parseInt(tokens[1].trim());
        if (!isLocalDate(localDate)) {
            throw new IllegalFormatException("Illegal release year: " + localDate);
        }
        String tariff = tokens[0].trim();



        return new Trip(city, transport,localDate, tariff);
    }
}