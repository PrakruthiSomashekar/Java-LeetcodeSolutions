package Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {
    public static void main(String[] args) {
        DiagonalTraverse d = new DiagonalTraverse();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        d.findDiagonalOrder(matrix);
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;

        if(row == 0)
            return new int[0];
        int col = matrix[0].length;
        int[] result = new int[row*col];
        List<Integer> list = new ArrayList<>();
        int k=0;
        for(int i=0; i<row+col-1; i++){

            list.clear();
            int r = i < col ? 0 : i - col + 1;
            int c = i < col ? i : col - 1;
            while(r<row && c>-1){
                list.add(matrix[r][c]);
                r++;
                c--;
            }
            if(i%2 == 0)
                Collections.reverse(list);
            int track=0;
            while (track<list.size()){
                result[k++] = list.get(track++);

            }
        }
        return result;
    }


}
