package Greedy;
// Given two strings: s1 and s2 with the same size, check if some permutation of string s1 can
// break some permutation of string s2 or vice-versa (in other words s2 can break s1).
//A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for all i between 0 and n-1

import java.util.Arrays;

public class StringBreakString {

    public static void main(String[] args) {
        StringBreakString string = new StringBreakString();
        System.out.println(string.checkIfCanBreak("leetcodee","interview"));
    }
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        return breakString(arr1,arr2) || breakString(arr2,arr1);
    }

    private boolean breakString(char[] arr1, char[] arr2) {
        for (int i=0;i<arr1.length;i++)
            if(arr1[i]>arr2[i])
                return false;
        return true;
    }
}
