package net.ukr.dreamsicle.Runner;


import net.ukr.dreamsicle.tariff.EconomyTrip;
import net.ukr.dreamsicle.tariff.FamilyTrip;
import net.ukr.dreamsicle.tariff.LuxeTrip;
import net.ukr.dreamsicle.tariff.StandartTrip;
import net.ukr.dreamsicle.trip.Transport;
import net.ukr.dreamsicle.trip.Trip;
import net.ukr.dreamsicle.trip.Trips;

import java.io.IOException;
import java.util.List;

import static java.util.Collections.reverseOrder;
import static net.ukr.dreamsicle.filtering.TripPredicates.filterDate;
import static net.ukr.dreamsicle.filtering.TripPredicates.filterPrice;
import static net.ukr.dreamsicle.filtering.onePredicate.allOf;
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

        List<Trip> trip = readTripsFromFile(INPUT_TEXT_FILE);

        User user = new User("Yura", "Loienko","dreamsicle@ukr.net",666249373);
        System.out.println(user.toString());//+user.myOldTrips());

        Trips trips = createTrips();

        System.out.println("Prices for all trips: "+trips.getPrice(Trip::getPrice));

        trips.sort(multiCriterion(reverseOrder(byDate()), byPrice()));
        trips = trips.filter(trips, allOf(filterPrice(1500), filterDate(13.05,25.05)));
        System.out.println("all trips \n"+trips);

        writeTripsIntoBinFile(trips, OUTPUT_BIN_FILE);


    }

    private static void writeTripsIntoBinFile(Trips trips, String outputBinFile) {
    }

    private static List<Trip> readTripsFromFile(String inputTextFile) {
        try {
            return TripIOUtils.readFilmsFromFile(inputTextFile);
        } catch (IOException e) {
            System.out.println("IO Error. " + e.getMessage());
            System.exit(0);
            return null;
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
            System.exit(0);
            return null;
        }
    }




    private static Trips createTrips() {
        Trips trips = new Trips();
        trips. addTrip(new Trip("London", Transport.BUS, 12.05,new EconomyTrip()));
        trips .addTrip(new Trip("Paris",Transport.CAR, 11.05, new LuxeTrip()));
        trips .addTrip(new Trip("Mexico",Transport.PLANE, 25.05, new StandartTrip()));
        trips .addTrip(new Trip("Kiev",Transport.WALKER,2.05,new EconomyTrip()));
        trips .addTrip(new Trip("Praha", Transport.BUS,8.05, new StandartTrip()));
        trips .addTrip(new Trip("Sidney",Transport.PLANE,29.05, new FamilyTrip()));
        trips .addTrip(new Trip("Los Angeles",Transport.PLANE,5.05, new LuxeTrip()));
        trips .addTrip(new Trip("Ottava",Transport.PLANE,14.05,new StandartTrip()));
        trips .addTrip(new Trip("London", Transport.PLANE, 12.05,new LuxeTrip()));
        return trips;
    }



}