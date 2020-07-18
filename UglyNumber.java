// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5

import java.util.*;
import java.util.stream.Collectors;

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        if(n <= 6 ) return n;

        List<Integer> uglys  = new ArrayList<>();
        uglys.add(1);// first ugly number

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while(uglys.size() < n){
            int next = (int) Math.min(Math.min(uglys.get(i2) * 2L, uglys.get(i3) * 3L), uglys.get(i5)* 5L);
            // increment the pointer, to avoid redundant multiplation in next loop
            if(next == uglys.get(i2) * 2L){
                i2++;
            }
            if(next == uglys.get(i3) * 3L){
                i3++;
            }
            if(next == uglys.get(i5) * 5L){
                i5++;
            }
            uglys.add(next);
        }
        return uglys.get(n-1);

    }

}
