package net.ukr.dreamsicle.sorting;

import java.util.Comparator;

/**
 * Created by Yura on 26.02.2017.
 */
public class CommonComparators {

    private CommonComparators() {}

    public static <T> Comparator<T> multiCriterion(Comparator<T>... comparators) {
        return (a, b) -> {
            for (Comparator<T> comparator : comparators) {
                int cmp = comparator.compare(a, b);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        };
    }
}
