package Array;// H-Index
// Given an array of citations (each citation is a non-negative integer) of a researcher, write a function
// to compute the researcher's h-index.

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3,0,6,1,5}));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        // 0 1 3 5 6
        int i=citations.length-1;
        while (i>=0){
            if(citations[i]<citations.length-i)
                break;
            i--;
        }
        return citations.length - (i+1);
    }
}
