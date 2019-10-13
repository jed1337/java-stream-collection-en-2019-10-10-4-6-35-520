package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.thoughtworks.collection.Filters.IS_EVEN;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int max = Math.max(left, right);
        int min = Math.min(left, right);

        return IntStream.rangeClosed(min, max)
                .boxed()
                .sorted(getIntegerComparator(left, right))
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int max = Math.max(left, right);
        int min = Math.min(left, right);

        return IntStream.rangeClosed(min, max)
                .filter(IS_EVEN)
                .boxed()
                .sorted(getIntegerComparator(left, right))
                .collect(Collectors.toList());
    }

    private Comparator<Integer> getIntegerComparator(int left, int right) {
        if (left < right) {
            return Comparator.naturalOrder();
        }
        return Comparator.reverseOrder();
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array)
                .filter(IS_EVEN)
                .boxed()
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array)
                .reduce((a, b) -> b)
                .orElse(0);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .filter(firstArrayElement -> IntStream.of(secondArray)
                        .anyMatch(secondArrayElement -> secondArrayElement == firstArrayElement))
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstArrayList = Arrays.asList(firstArray);
        List<Integer> secondArrayList = Arrays.stream(secondArray)
                .filter(element -> !firstArrayList.contains(element))
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(firstArrayList);
        resultList.addAll(secondArrayList);

        return resultList;
    }
}
