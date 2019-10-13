package com.thoughtworks.collection;

import java.util.List;

import static com.thoughtworks.collection.PredicateFilters.FILTER_IS_ODD;
import static com.thoughtworks.collection.Utils.getMedianFromList;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
                .reduce(Math::max)
                .orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream()
                .reduce(Math::min)
                .orElse(0);
    }

    public double getAverage() {
        return arrayList.stream()
                .mapToDouble(i -> i)
                .average()
                .orElse(0);

    }

    public double getOrderedMedian() {
        return getMedianFromList(arrayList);
    }

    public int getFirstEven() {
        return arrayList.stream()
                .reduce(0, (a, b) -> a==0 && b%2==0? a=b : a);
    }

    public int getIndexOfFirstEven() {
        return arrayList.indexOf(getFirstEven());
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        return getMedianFromList(arrayList);
    }

    public int getLastOdd() {
        return arrayList.stream()
                .filter(FILTER_IS_ODD)
                .reduce((a,b)-> b)
                .orElse(0);
    }

    public int getIndexOfLastOdd() {
        return arrayList.indexOf(getLastOdd());
    }
}
