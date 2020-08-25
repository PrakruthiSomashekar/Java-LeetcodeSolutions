package Array;// Given the number of stairs return number of possibilities to reach that step with combination of 1 & 2 steps at a time

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(4));
    }

    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        arr[0] = arr[1] = 1;
        for(int i=2;i<=n;i++)
            arr[i] = arr[i-1] + arr[i-2];
        return arr[n];
    }
}
