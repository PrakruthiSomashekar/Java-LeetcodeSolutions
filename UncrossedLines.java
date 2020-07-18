// we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
//A[i] == B[j];
//The line we draw does not intersect any other connecting (non-horizontal) line.
// Return the maximum number of connecting lines we can draw in this way.

public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j]) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        UncrossedLines u = new UncrossedLines();
        int[] A = {2,5,1,2,5}; int[]B = {10,5,2,1,5,2};
        System.out.println(u.maxUncrossedLines(A,B));
    }
}
