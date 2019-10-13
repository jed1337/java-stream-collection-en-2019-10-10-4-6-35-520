package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> resultList = new ArrayList<>();

        while (true){
            number -= random.nextInt(3);
            if(number<=0){
                break;
            } else{
                resultList.add(number);
            }
        }
        return resultList;
    }
}
