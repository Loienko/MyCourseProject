package net.ukr.dreamsicle.filtering;

/**
 * Created by Yura on 26.02.2017.
 */
public interface Predicate<T> {
    boolean apply(T elem);
}
