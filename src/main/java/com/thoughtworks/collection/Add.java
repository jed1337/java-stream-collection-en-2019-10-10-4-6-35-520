package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.thoughtworks.collection.PredicateFilters.*;
import static com.thoughtworks.collection.Utils.getMedianFromList;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);

        return IntStream.rangeClosed(min, max)
                .filter(IS_EVEN)
                .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);

        return IntStream.rangeClosed(min, max)
                .filter(IS_ODD)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(element -> element * 3 + 2)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(element -> {
                    if (element % 2 != 0) {
                        return element * 3 + 2;
                    }
                    return element;
                })
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(FILTER_IS_ODD)
                .mapToInt(element -> element * 3 + 5)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream()
                .filter(FILTER_EVEN)
                .collect(Collectors.toList());

        return getMedianFromList(evenList);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(FILTER_EVEN)
                .collect(Collectors.summarizingDouble(i -> i))
                .getAverage();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(FILTER_EVEN)
                .anyMatch(element -> element.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(FILTER_EVEN)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream()
                .filter(FILTER_EVEN)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream()
                .filter(FILTER_IS_ODD)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> integerList = new ArrayList<>();
        integerList.addAll(evenList);
        integerList.addAll(oddList);

        return integerList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> processedList = new ArrayList<>();
        for (int curIndex = 0, nextIndex=1; nextIndex < arrayList.size(); curIndex++, nextIndex++) {
            Integer currentValue = arrayList.get(curIndex);
            Integer nextValue = arrayList.get(nextIndex);
            processedList.add((currentValue + nextValue) * 3);
        }
        return processedList;
    }
}
