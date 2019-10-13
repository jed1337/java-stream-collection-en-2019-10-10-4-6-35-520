package com.thoughtworks.collection;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateFilters {
    private PredicateFilters(){}

    public static final IntPredicate IS_EVEN = element -> element % 2 == 0;
    public static final IntPredicate IS_ODD = element -> element % 2 != 0;
    public static final Predicate<Integer> FILTER_IS_ODD = element -> element % 2 != 0;
    public static final Predicate<Integer> FILTER_EVEN = element -> element % 2 == 0;
}
