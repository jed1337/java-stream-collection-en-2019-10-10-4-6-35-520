package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.Collectors;

import static com.thoughtworks.collection.PredicateFilters.*;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        return array.stream()
                .filter(FILTER_IS_EVEN)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return array.stream()
                .filter(element->element%3==0)
                .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream()
                .filter(secondList::contains)
                .collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        return array.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}