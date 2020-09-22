// 198. House Robber
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
package Array;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
    }

    public static int rob(int[] nums) {
        int[] arr = new int[nums.length];
        if(nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        arr[0] = nums[0];
        arr[1] = Math.max(nums[1],nums[0]);

        for(int i=2; i<nums.length; i++){
            arr[i] = Math.max((nums[i]+arr[i-2]),arr[i-1]);
        }
        return Math.max(arr[nums.length-1],arr[nums.length-2]);
    }
}
