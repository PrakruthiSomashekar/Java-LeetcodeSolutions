// Pascal's Triangle II
// Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it.
//          1
//         1 1
//        1 2 1
//       1 3 3 1
//      1 4 6 4 1

import java.util.*;

public class PascalsTriangle2 {

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 0)return res;
        for(int i = 1; i <= rowIndex; i++){
            long num = ((long)res.get(i-1)*(long)(rowIndex-i+1))/i;
            res.add((int)num);
        }
        return res;
    }
}
