package Array;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageOverlap {

    protected List<Pair<Integer, Integer>> non_zero_cells(int[][] M) {
        List<Pair<Integer, Integer>> ret = new ArrayList<>();
        for (int row = 0; row < M.length; ++row)
            for (int col = 0; col < M.length; ++col)
                if (M[row][col] == 1)
                    ret.add(new Pair<>(row, col));
        return ret;
    }

    public int largestOverlap(int[][] A, int[][] B) {

        List<Pair<Integer, Integer>> A_ones = non_zero_cells(A);
        List<Pair<Integer, Integer>> B_ones = non_zero_cells(B);

        int maxOverlaps = 0;
        HashMap<Pair<Integer, Integer>, Integer> groupCount = new HashMap<>();

        for (Pair<Integer, Integer> a : A_ones)
            for (Pair<Integer, Integer> b : B_ones) {
                Pair<Integer, Integer> vec =
                        new Pair<>(b.getKey() - a.getKey(), b.getValue() - a.getValue());

                if (groupCount.containsKey(vec)) {
                    groupCount.put(vec, groupCount.get(vec) + 1);
                } else {
                    groupCount.put(vec, 1);
                }
                maxOverlaps = Math.max(maxOverlaps, groupCount.get(vec));
            }

        return maxOverlaps;
    }

    public static void main(String[] args) {
        ImageOverlap overlap = new ImageOverlap();
        int[][] A = new int[][]{{1,0,1},{0,0,0},{1,1,0}};
        int[][] B = new int[][]{{1,1,0},{0,0,0},{1,1,0}};
        System.out.println(overlap.largestOverlap(A,B));
    }
}