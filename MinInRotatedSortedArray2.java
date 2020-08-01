// 154. Find Minimum in Rotated Sorted Array II
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e.,  [0,1,2,2,4,5,6,7] might become  [2,4,5,6,7,0,1,2]).
//
//Find the minimum element.
//The array may contain duplicates.

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MinInRotatedSortedArray2 {

    public static void main(String[] args) {
        int[] arr = {2,4,5,6,7,0,1,2};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(int i=0;i<nums.length;i++)
//            set.add(nums[i]);
//
//        return Collections.min(set);

        int lo =0;
        int n = nums.length;
        int hi = n-1;
        int min = nums[lo];
        while(lo<hi){
            while(lo <hi && lo <n-2 && nums[lo]==nums[lo+1] ){
                lo = lo+1;
            }
            while(lo<hi && hi >=1 && nums[hi]== nums[hi-1]){
                hi = hi-1;
            }
            int mid = lo +(hi-lo)/2;
            if(mid-1>=0 && mid+1<=n-1 && nums[mid]<nums[mid-1]&& nums[mid]>nums[mid+1]){
                return nums[mid];
            }
            if(nums[mid]<nums[hi]){
                hi = mid;
            } else {
                lo = mid+1;
            }


        }
        return nums[lo];
    }

}
