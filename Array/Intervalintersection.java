package Array;// Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
//Return the intersection of these two interval lists.


import java.util.ArrayList;
import java.util.List;

public class Intervalintersection {

    public static void main(String[] args) {
        int[][] a = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] b = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        Intervalintersection i = new Intervalintersection();
        i.intervalIntersection(a,b);
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
