package Array;// Reverse bits of a given 32 bits unsigned integer.

import java.util.Arrays;
import java.util.Collections;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(1010001));
    }

    public static int reverseBits(int n) {
        String arr = Integer.toString(n);
        char[] ar = arr.toCharArray();
        int i;
        char temp;
        for (i = 0; i < ar.length / 2; i++) {
            temp = ar[i];
            ar[i] = ar[ar.length - i - 1];
            ar[ar.length - i - 1] = temp;
        }
        StringBuilder s = new StringBuilder();
        for (char k : ar)
        {
            s.append(k); //add all the ints to a string
        }

        return Integer.parseInt(s.toString());
    }
}
