package Array;// Kadane's algorithm

public class MaxSumCircularSubArray {

    public static void main(String[] args) {
        MaxSumCircularSubArray m = new MaxSumCircularSubArray();
        System.out.println(m.maxSubarraySumCircular(new int[]{-2}));
    }

    public int maxSubarraySumCircular(int[] A) {
        int sum = A[0];
        int maxSoFar = A[0];
        int maxTotal = A[0];
        int minTotal = A[0];
        int minSoFar = A[0];
        for(int i = 1; i < A.length; i++){
            int num = A[i];
            maxSoFar = Math.max(num, maxSoFar + num);
            maxTotal = Math.max(maxSoFar, maxTotal);

            minSoFar = Math.min(num, minSoFar + num);
            minTotal = Math.min(minTotal, minSoFar);

            sum += num;
        }
        if(sum == minSoFar) return maxTotal;
        return Math.max(sum - minTotal, maxTotal);
    }

}
