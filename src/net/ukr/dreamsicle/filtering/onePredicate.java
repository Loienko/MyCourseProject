package net.ukr.dreamsicle.filtering;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Yura on 26.02.2017.
 */
public class onePredicate<T> implements Predicate<T> {

    private final List<Predicate<T>> predicates;

    public static <T> Predicate<T> allOf(Predicate<T>... predicates) {
        return new onePredicate<>(predicates);
    }

    public onePredicate(List<Predicate<T>> predicates) {
        this.predicates = predicates;
    }

    public onePredicate(Predicate<T>... predicates) {
        this(Arrays.asList(predicates));
    }



    @Override
    public boolean apply(T elem) {
        for (Predicate<T> predicate : predicates) {
            if (predicate.apply(elem)){
                return true;
            }
        }
        return false;
    }
}
