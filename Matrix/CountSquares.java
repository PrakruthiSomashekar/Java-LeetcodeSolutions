package Matrix;
// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
// O(m,n) time and space complexity

public class CountSquares {
    public static void main(String[] args) {
        CountSquares c = new CountSquares();
//        int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        int[][] matrix = {{1,0,1,},{1,1,0},{1,1,0}};
        System.out.println(c.countSquares(matrix));
    }

    public int countSquares(int[][] matrix) {
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] mat = new int[row][col];

        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++) {
                if (matrix[i][j] == 1){
                    if(i==0 || j==0)
                        mat[i][j] = 1;
                    else
                        mat[i][j] = Math.min(mat[i-1][j],Math.min(mat[i-1][j-1],mat[i][j-1])) + 1;
                    count = count + mat[i][j];
                }else mat[i][j] = matrix[i][j];
            }
        }
        return count;
    }
}
