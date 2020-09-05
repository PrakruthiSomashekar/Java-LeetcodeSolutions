// Largest Time for the Given Digits
// Given an array of 4 digits, return the largest 24 hour time that can be made.
//
//The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
//
//Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestTime {

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{2,0,6,6}));
    }

    public static String largestTimeFromDigits(int[] A) {
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.sort(list);
        Collections.reverse(list);
        StringBuilder result = new StringBuilder();
        if(list.get(0)>5 && list.get(1)>5){
            result.append(getMax(1,list));
            result.append(getMax(9, list));

        } else {

            String hour = getMax(2, list);
            result.append(hour);
            switch (hour) {
                case "2":
                    result.append(getMax(3, list));
                    break;
                case "1":
                case "0":
                    result.append(getMax(9, list));
                    break;
                default:
                    return "";

            }
        }
        result.append(":");
        result.append(getMax(5, list));
        result.append(getMax(9, list));
        if(result.length() == 5)
            return result.toString();
        else return "";

    }

    private static String getMax(int max, List<Integer> list) {
        for(Integer i: list){
            if(i<=max){
                list.remove((Integer)i);
                return i.toString();
            }
        }
        return "";
    }
}
