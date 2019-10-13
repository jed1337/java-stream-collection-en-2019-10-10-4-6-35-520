package com.thoughtworks.collection;

import java.util.List;

public class Utils {
    private Utils(){}

    public static double getMedianFromList(List<Integer> arrayList){
        if(arrayList.size()%2==0){
            double leftMiddleElement  = arrayList.get(arrayList.size() / 2-1);
            double rightMiddleElement = arrayList.get((arrayList.size() / 2));

            return (leftMiddleElement+rightMiddleElement)/2;
        } else{
            return arrayList.get(arrayList.size() / 2);
        }
    }
}
