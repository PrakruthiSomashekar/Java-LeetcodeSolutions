// Maximum Product Subarray
// Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
package Array;

public class MaximumProductSubArray {

    public static int maxProduct(int[] nums) {
        int result = nums[0];

        for(int i=1,imax=result, imin=result;i<nums.length;i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            result = Math.max(result,imax);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-1,3,-2,-3,0,3,4,5}));
    }
}

