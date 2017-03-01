package net.ukr.dreamsicle.Runner;


import net.ukr.dreamsicle.io.IllegalFormatException;
import net.ukr.dreamsicle.io.TripIO;
import net.ukr.dreamsicle.trip.Trip;
import org.jetbrains.annotations.Nullable;


import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;
import static java.util.Collections.reverseOrder;
import static net.ukr.dreamsicle.filtering.TripPredicates.filterDate;
import static net.ukr.dreamsicle.filtering.TripPredicates.filterPrice;
import static net.ukr.dreamsicle.filtering.Predicates.allOf;
import static net.ukr.dreamsicle.sorting.CommonComparators.multiCriterion;
import static net.ukr.dreamsicle.sorting.TripComparators.byDate;
import static net.ukr.dreamsicle.sorting.TripComparators.byPrice;


/**
 * Created by Yura on 13.02.2017.
 */
public class MyTripsRunner {

    public static final String INPUT_TEXT_FILE = "files/trips.csv";
    public static final String OUTPUT_BIN_FILE = "files/trips.dat";

    public static void main(String[] args) {

        List<Trip> trips = readTripsFromFile(INPUT_TEXT_FILE);

        User user = new User("Yura", "Loienko","dreamsicle@ukr.net",666249373);
        System.out.println(user.toString());  //+user.myOldTrips());

        System.out.println("Prices for all trips: "+trips.getPrice(Trip::getPrice));

        trips.sort(multiCriterion(reverseOrder(byDate()), byPrice()));
        trips = trips.filter(trips, allOf(filterPrice(1500), filterDate(13.05, 25.05)));
        System.out.println("all trips \n"+trips);

        writeTripsIntoBinFile(trips, OUTPUT_BIN_FILE);


    }

    @Nullable
    private static List<Trip> readTripsFromFile(String fileName) {
        try {
            return TripIO.readTripsFromFile(fileName);
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
            exit(0);
            return null;
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
           exit(0);
            return null;
        }
    }

    private static void writeTripsIntoBinFile(List<Trip> trips, String fileName) {
        try {
            TripIO.writeTripsIntoBinFile(fileName, trips);
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
        }
    }

}